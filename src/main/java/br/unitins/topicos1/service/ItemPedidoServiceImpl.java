package br.unitins.topicos1.service;

import br.unitins.topicos1.dto.EnderecoResponseDTO;
import br.unitins.topicos1.dto.ItemPedidoDTO;
import br.unitins.topicos1.dto.ItemPedidoResponseDTO;
import br.unitins.topicos1.model.ItemPedido;
import br.unitins.topicos1.model.Pedido;
import br.unitins.topicos1.model.Product;
import br.unitins.topicos1.repository.ItemPedidoRepository;
import br.unitins.topicos1.repository.PedidoRepository;
import br.unitins.topicos1.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

@ApplicationScoped
public class ItemPedidoServiceImpl implements ItemPedidoService {

    @Inject
    ItemPedidoRepository itemPedidoRepository;

    @Inject
    ProductRepository productRepository;

    @Inject
    PedidoRepository pedidoRepository;

    @Override
    @Transactional
    public ItemPedidoResponseDTO insert(@Valid ItemPedidoDTO dto, Long idUsuario) {
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPreco(dto.preco());
        itemPedido.setQuantidade(dto.quantidade());

        Product product = productRepository.findById(dto.productId());
        if (product == null) {
            throw new NotFoundException("Produto não encontrado");
        }
        itemPedido.setProduct(product);

        Pedido pedido = pedidoRepository.findByIdUser(idUsuario);
        if (pedido == null) {
            throw new NotFoundException("Pedido não encontrado para o usuário com ID: " + idUsuario);
        }
        itemPedido.setPedido(pedido);

        itemPedidoRepository.persist(itemPedido);

        return ItemPedidoResponseDTO.valueOf(itemPedido);
    }

    @Override
    @Transactional
    public ItemPedidoResponseDTO update(Long id, @Valid ItemPedidoDTO dto, Long idUsuario) {
        ItemPedido itemPedido = itemPedidoRepository.findById(id);
        if (itemPedido == null) {
            throw new NotFoundException("ItemPedido não encontrado com o ID: " + id);
        }

        itemPedido.setPreco(dto.preco());
        itemPedido.setQuantidade(dto.quantidade());

        Product product = productRepository.findById(dto.productId());
        if (product == null) {
            throw new NotFoundException("Produto não encontrado");
        }
        itemPedido.setProduct(product);

        Pedido pedido = pedidoRepository.findByIdUser(idUsuario);
        if (pedido == null) {
            throw new NotFoundException("Pedido não encontrado para o usuário com ID: " + idUsuario);
        }
        itemPedido.setPedido(pedido);

        itemPedidoRepository.persist(itemPedido);

        return ItemPedidoResponseDTO.valueOf(itemPedido);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!itemPedidoRepository.deleteById(id)) {
            throw new NotFoundException("ItemPedido não encontrado");
        }
    }

    @Override
    public ItemPedidoResponseDTO findById(Long id) {
        ItemPedido itemPedido = itemPedidoRepository.findById(id);
        if (itemPedido == null) {
            throw new NotFoundException("ItemPedido não encontrado");
        }
        return ItemPedidoResponseDTO.valueOf(itemPedido);
    }

    @Override
    public List<ItemPedidoResponseDTO> findByAll() {
        return itemPedidoRepository.listAll().stream()
                .map(e -> ItemPedidoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<ItemPedidoResponseDTO> findByIdUser(Long idUsuario) {
        return itemPedidoRepository.findByIdUser(idUsuario).stream()
                .map(e -> (ItemPedidoResponseDTO) ItemPedidoResponseDTO.valueOf(e))
                .toList();
    }

}
