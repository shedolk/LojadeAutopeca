package br.unitins.topicos1.dto;

import java.util.List;

import br.unitins.topicos1.model.ItemCarrinho;

public record ItemCarrinhoResponseDTO(
        Integer quantidade,
        Double preco,
        Long idProduto,
        String nome) {

    public static ItemCarrinhoResponseDTO valueOf(ItemCarrinho item) {
        return new ItemCarrinhoResponseDTO(
                item.getQuantidade(),
                item.getPreco(),
                item.getProduct().getId(),
                item.getProduct().getNome());
    }

    public static List<ItemCarrinhoResponseDTO> valueOf(List<ItemCarrinho> item) {
        return item.stream().map(i -> ItemCarrinhoResponseDTO.valueOf(i)).toList();
    }

}
