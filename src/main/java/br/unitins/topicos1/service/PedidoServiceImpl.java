package br.unitins.topicos1.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.ItemPedidoDTO;
import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.dto.PedidoResponseDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.TelefoneResponseDTO;
import br.unitins.topicos1.model.Cupom;
import br.unitins.topicos1.model.ItemPedido;
import br.unitins.topicos1.model.Pagamento;
import br.unitins.topicos1.model.Pedido;
import br.unitins.topicos1.model.Product;
import br.unitins.topicos1.model.StatusPedido;
import br.unitins.topicos1.model.Telefone;
import br.unitins.topicos1.model.Usuario;
import br.unitins.topicos1.repository.CupomRepository;
import br.unitins.topicos1.repository.PagamentoRepository;
import br.unitins.topicos1.repository.PedidoRepository;
import br.unitins.topicos1.repository.ProductRepository;
import br.unitins.topicos1.repository.UsuarioRepository;
import br.unitins.topicos1.resource.PedidoResource;
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

    @Inject
    ItemPedidoService itemPedidoRepository;

    private static final Logger LOG = Logger.getLogger(PedidoResource.class);

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

        // // calculo do total do pedido
        // Double total = 0.0;
        // for (ItemPedidoDTO itemDto : dto.itens()) {
        // total += (itemDto.preco() * itemDto.quantidade());
        // }
        pedido.setTotalPedido(dto.totalPedido());

        // buscando o usuario pelo login
        Usuario usuario = usuarioRepository.findById(dto.usuario_id());
        pedido.setUsuario(usuario);
        // pedido.setUsuario(usuarioRepository.findByLogin(login));

        // salvando no banco
        pedidoRepository.persist(pedido);

        // atualizando o estoque

        return PedidoResponseDTO.valueOf(pedido);
    }

    @Override
    @Transactional
    public PedidoResponseDTO update(Long id, PedidoDTO dto) {
        Pedido pedido = pedidoRepository.findById(id);

        pedido.setDataPedido(dto.dataPedido());
        Pagamento pagamento = pagamentoRepository.findById(dto.pagamento_id());
        pedido.setPagamento(pagamento);
        pedido.setStatusPedido(StatusPedido.valueOf(dto.statusPedido()));
        Cupom cupom = cupomRepository.findById(dto.cupom_id());
        pedido.setCupom(cupom);
        pedido.setTotalPedido(dto.totalPedido());

        // buscando o usuario pelo login
        Usuario usuario = usuarioRepository.findById(dto.usuario_id());
        pedido.setUsuario(usuario);

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

    // @Override
    // @Transactional
    // public void delete(Long id) {
    // try {
    // if (!pedidoRepository.deleteById(id)) {
    // throw new NotFoundException("Usuário não encontrado");
    // }
    // } catch (Exception e) {
    // throw new RuntimeException("Erro ao excluir usuário", e);
    // }
    // }

    @Override
    @Transactional
    public void delete(Long id) {
        try {
            // Verifica se o pedido existe
            Pedido pedido = pedidoRepository.findById(id);
            if (pedido == null) {
                throw new NotFoundException("Pedido não encontrado");
            }

            // Remove o pedido
            pedidoRepository.delete(pedido);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir pedido", e);
        }
    }
}
