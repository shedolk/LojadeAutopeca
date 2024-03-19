package br.unitins.topicos1.dto;

import java.util.List;

import br.unitins.topicos1.model.ItemPedido;

public record ItemPedidoResponseDTO(
        Long id,
        Integer quantidade,
        Double preco,
        ProductResponseDTO product,
        PedidoResponseDTO pedido) {
    public static ItemPedidoResponseDTO valueOf(ItemPedido itemPedido) {
        return new ItemPedidoResponseDTO(
                itemPedido.getId(),
                itemPedido.getQuantidade(),
                itemPedido.getPreco(),
                ProductResponseDTO.valueOf(itemPedido.getProduct()),
                PedidoResponseDTO.valueOf(itemPedido.getPedido()));
    }

    public static List<ItemPedidoResponseDTO> valueOf(List<ItemPedido> item) {
        return item.stream().map(i -> ItemPedidoResponseDTO.valueOf(i)).toList();
    }
}