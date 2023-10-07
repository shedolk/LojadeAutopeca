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
public class PedidoServiceImpl implements PedidoService  {
    
    @Inject
    PedidoRepository repository;

    @Override
    @Transactional
    public PedidoResponseDTO insert(PedidoDTO dto) {
         Pedido novoPedido = new Pedido();
        novoPedido.setDate(dto.getDate());
        novoPedido.setEndereco(dto.getEndereco());
        novoPedido.setCliente(dto.getCliente());

        if (dto.getListaItemPedido() != null && 
                    !dto.getListaItemPedido().isEmpty()){
            novoPedido.setItemPedido(new ArrayList<ItemPedido>());
            for (ItemPedidoDTO item : dto.getListaItemPedido()) {
                ItemPedido itemPedido = new ItemPedido();
                itemPedido.setQuantidade(item.quantidade());
                novoPedido.getItemPedido().add(itemPedido);
            }
        }

        repository.persist(novoPedido);

        return PedidoResponseDTO.valueOf(novoPedido);
    }

    @Override
    @Transactional
    public PedidoResponseDTO update(PedidoDTO dto, Long id) {
        Pedido pedido = repository.findById(id);

            pedido.setDate(dto.getDate());
            pedido.setEndereco(dto.getEndereco());
            pedido.setCliente(dto.getCliente());
    
            List<ItemPedido> itemPedidos = new ArrayList<>();
                for (ItemPedidoDTO item : dto.getListaItemPedido()) {
                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(item.quantidade());
                    itemPedidos.add(itemPedido);
        }
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

    @Override
    public List<PedidoResponseDTO> findByCodigo(String codigo) {
        return repository.findByCodigo(codigo).stream()
        .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<PedidoResponseDTO> findByAll() {
        return repository.listAll().stream()
        .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }
    
}
