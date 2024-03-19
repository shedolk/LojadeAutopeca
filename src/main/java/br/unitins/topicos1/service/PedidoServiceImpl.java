package br.unitins.topicos1.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.unitins.topicos1.dto.ItemPedidoDTO;
import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.dto.PedidoResponseDTO;
import br.unitins.topicos1.model.Cupom;
import br.unitins.topicos1.model.ItemPedido;
import br.unitins.topicos1.model.Pagamento;
import br.unitins.topicos1.model.Pedido;

import br.unitins.topicos1.model.StatusPedido;
import br.unitins.topicos1.model.Usuario;
import br.unitins.topicos1.repository.CupomRepository;
import br.unitins.topicos1.repository.PagamentoRepository;
import br.unitins.topicos1.repository.PedidoRepository;
import br.unitins.topicos1.repository.ProductRepository;
import br.unitins.topicos1.repository.UsuarioRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {

    @Inject
    ProductRepository produtoRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    PedidoRepository pedidoRepository;

    @Inject
    PagamentoRepository pagamentoRepository;

    @Inject
    CupomRepository cupomRepository;

    @Override
    @Transactional
    public PedidoResponseDTO insert(PedidoDTO dto, String login) {
        Pedido pedido = new Pedido();
        pedido.setDataPedido(LocalDateTime.now());
        Pagamento pagamento = pagamentoRepository.findById(dto.pagamento_id());
        pedido.setPagamento(pagamento);
        pedido.setStatusPedido(StatusPedido.valueOf(dto.statusPedido()));
        Cupom cupom = cupomRepository.findById(dto.cupom_id());
        pedido.setCupom(cupom);

        // calculo do total do pedido
        Double total = 0.0;
        for (ItemPedidoDTO itemDto : dto.itens()) {
            total += (itemDto.preco() * itemDto.quantidade());
        }
        pedido.setTotalPedido(total);

        // buscando o usuario pelo login
        Usuario usuario = usuarioRepository.findById(dto.usuario_id());
        pedido.setUsuario(usuario);
        // pedido.setUsuario(usuarioRepository.findByLogin(login));

        // adicionando os itens do pedido
        pedido.setItens(new ArrayList<ItemPedido>());
        for (ItemPedidoDTO itemDto : dto.itens()) {
            ItemPedido item = new ItemPedido();
            item.setPreco(itemDto.preco());
            item.setQuantidade(itemDto.quantidade());
            item.setPedido(pedido);

            pedido.getItens().add(item);
        }

        // salvando no banco
        pedidoRepository.persist(pedido);

        // atualizando o estoque

        return PedidoResponseDTO.valueOf(pedido);

    }

    @Override
    public PedidoResponseDTO findById(Long id) {
        return PedidoResponseDTO.valueOf(pedidoRepository.findById(id));
    }

    @Override
    public List<PedidoResponseDTO> findByAll() {
        return pedidoRepository.listAll().stream()
                .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<PedidoResponseDTO> findByAll(String login) {
        return pedidoRepository.listAll().stream()
                .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        try {
            if (!pedidoRepository.deleteById(id)) {
                throw new NotFoundException("Usuário não encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir usuário", e);
        }
    }
}
