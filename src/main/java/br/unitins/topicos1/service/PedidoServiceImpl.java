package br.unitins.topicos1.service;

import java.util.ArrayList;
import java.util.List;


import br.unitins.topicos1.dto.ItemPedidoDTO;
import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.dto.PedidoResponseDTO;
import br.unitins.topicos1.modelo.ItemPedido;
import br.unitins.topicos1.modelo.Pedido;
import br.unitins.topicos1.repository.PedidoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {
    @Inject
    PedidoRepository repository;

    @Override
    @Transactional
    public PedidoResponseDTO insert(PedidoDTO dto) {
        Pedido novoPedido = new Pedido();
        novoPedido.setCodigo(dto.codigo());
        novoPedido.setDate(dto.date());

        if (dto.itemPedido() != null &&
                !dto.itemPedido().isEmpty()) {
            novoPedido.setItemPedido(new ArrayList<ItemPedido>());
            for (ItemPedidoDTO item : dto.itemPedido()) {
                ItemPedido itemPedido = new ItemPedido();
                itemPedido.setQuantidade(item.quantidade());
                novoPedido.getItemPedido().add(itemPedido);
            }
        }

       novoPedido.setCliente(dto.cliente());

        repository.persist(novoPedido);
        return PedidoResponseDTO.valueOf(novoPedido);

    }

    @Override
    @Transactional
    public PedidoResponseDTO update(PedidoDTO dto, Long id) {
        Pedido pedido = repository.findById(id);

        pedido.setCodigo(dto.codigo());
        pedido.setDate(dto.date());

        List<ItemPedido> itensPedido = new ArrayList<>();
        for (ItemPedidoDTO itemDTO : dto.itemPedido()) {
            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setQuantidade(itemDTO.quantidade());
            itensPedido.add(itemPedido);
        }
        pedido.setItemPedido(itensPedido);

        pedido.setCliente(dto.cliente());

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

    @Override
    public List<PedidoResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

}
