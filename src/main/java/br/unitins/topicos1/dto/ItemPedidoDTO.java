package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.ItemPedido;

public record ItemPedidoDTO(

        Integer quantidade,
        Double preco,
        Long productId,
        Long pedidoId

) {

    public static ItemPedidoDTO valueOf(ItemPedido itemPedido) {
        return new ItemPedidoDTO(
                itemPedido.getQuantidade(),
                itemPedido.getPreco(),
                itemPedido.getProduct() != null ? itemPedido.getProduct().getId() : null,
                itemPedido.getPedido() != null ? itemPedido.getPedido().getId() : null);

    }

}
