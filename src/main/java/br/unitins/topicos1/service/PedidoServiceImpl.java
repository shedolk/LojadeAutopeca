package br.unitins.topicos1.service;

import java.util.ArrayList;
import java.util.List;

import br.unitins.topicos1.dto.ItemPedidoDTO;
import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.dto.PedidoResponseDTO;
import br.unitins.topicos1.modelo.ItemPedido;
import br.unitins.topicos1.modelo.Pedido;
import br.unitins.topicos1.repository.ClienteRepository;
import br.unitins.topicos1.repository.PedidoRepository;
import br.unitins.topicos1.repository.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {

    @Inject
    ProdutoRepository produtoRepository;

    @Inject
    ClienteRepository clienteRepository;

    @Inject
    PedidoRepository repository;

    @Override
    @Transactional
    public PedidoResponseDTO insert(PedidoDTO dto, String login) {
        Pedido novoPedido = new Pedido();

        Double total = 0.0;
        for (ItemPedidoDTO itemDto : dto.itens()) {
            total += (itemDto.preco() * itemDto.quantidade());
        }
        novoPedido.setTotalPedido(total);

        novoPedido.setCodigo(dto.codigo());
        novoPedido.setDate(dto.date());

        if (dto.itens() != null &&
                !dto.itens().isEmpty()) {
            novoPedido.setItemPedido(new ArrayList<ItemPedido>());
            for (ItemPedidoDTO item : dto.itens()) {
                ItemPedido itemPedido = new ItemPedido();
                itemPedido.setQuantidade(item.quantidade());
                itemPedido.setPreco(item.preco());
                itemPedido.setProduto(produtoRepository.findById(item.idProduto()));
                novoPedido.getItemPedido().add(itemPedido);
            }
        }

        novoPedido.setCliente(clienteRepository.findByLogin(login));

        repository.persist(novoPedido);
        return PedidoResponseDTO.valueOf(novoPedido);

    }

    @Override
    public List<PedidoResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

    @Override
    @Transactional
    public PedidoResponseDTO update(PedidoDTO dto, Long id, String login) {
        Pedido pedido = repository.findById(id);

        pedido.setCodigo(dto.codigo());
        pedido.setDate(dto.date());

        List<ItemPedido> itensPedido = new ArrayList<>();
        for (ItemPedidoDTO itemDTO : dto.itens()) {
            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setQuantidade(itemDTO.quantidade());
            itemPedido.setPreco(itemDTO.preco());
            itemPedido.setProduto(produtoRepository.findById(itemDTO.idProduto()));
            itensPedido.add(itemPedido);
        }
        pedido.setItemPedido(itensPedido);

        pedido.setCliente(clienteRepository.findByLogin(login));

        repository.persist(pedido);

        return PedidoResponseDTO.valueOf(pedido);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public PedidoResponseDTO findById(Long id) {
        return PedidoResponseDTO.valueOf(repository.findById(id));
    }

    public List<PedidoResponseDTO> findByCodigo(String codigo) {
        return repository.findByCodigo(codigo).stream()
                .map(e -> PedidoResponseDTO.valueOf(e))
                .toList();
    }

}
