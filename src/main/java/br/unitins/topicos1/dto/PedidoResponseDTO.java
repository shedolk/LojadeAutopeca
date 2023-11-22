package br.unitins.topicos1.dto;

import java.time.LocalDate;
import java.util.List;

import br.unitins.topicos1.model.Pedido;


public record PedidoResponseDTO(
    Long id,
    String codigo,
    LocalDate date,
    List<ItemPedidoDTO> itens,
    ClienteResponseDTO cliente,
    Double totalPedido 
) {
    public static PedidoResponseDTO valueOf(Pedido pedido) {
        return new PedidoResponseDTO(
            pedido.getId(),
            pedido.getCodigo(),
            pedido.getDate(),
            pedido.getItemPedido()
                .stream()
                .map(ItemPedidoDTO::valueOf)
                .toList(),
                ClienteResponseDTO.valueOf(pedido.getCliente()),
                pedido.getTotalPedido()
        );
    }
}

