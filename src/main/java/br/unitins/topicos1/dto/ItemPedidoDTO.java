package br.unitins.topicos1.dto;

import br.unitins.topicos1.modelo.ItemPedido;

public record ItemPedidoDTO(
        Long id,
        int quantidade

) {
    public static ItemPedidoDTO valueOf(ItemPedido itemPedido) {
        return new ItemPedidoDTO(
                itemPedido.getId(),
                itemPedido.getQuantidade());
    }
}
