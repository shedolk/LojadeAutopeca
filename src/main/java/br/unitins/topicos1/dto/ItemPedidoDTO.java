package br.unitins.topicos1.dto;

import br.unitins.topicos1.modelo.ItemPedido;

public record ItemPedidoDTO(
    Integer quantidade,
    Double preco,
    Long idProduto
) {
     public static ItemPedidoDTO valueOf(ItemPedido item){
        return new ItemPedidoDTO(
            item.getQuantidade(),
            item.getPreco(),
            item.getProduto().getId()
        );
    }
}
