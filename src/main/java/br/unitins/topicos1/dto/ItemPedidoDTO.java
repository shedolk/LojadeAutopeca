package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.ItemPedido;

public record ItemPedidoDTO(

        Integer quantidade,
        Double preco

) {
    public static ItemPedidoDTO valueOf(ItemPedido itemPedido) {
        return new ItemPedidoDTO(
                itemPedido.getQuantidade(),
                itemPedido.getPreco());

    }

}
