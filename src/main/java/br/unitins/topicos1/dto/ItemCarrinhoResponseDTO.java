package br.unitins.topicos1.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos1.model.Category;
import br.unitins.topicos1.model.ItemCarrinho;

public record ItemCarrinhoResponseDTO(
        Integer quantidade,
        Double preco,
        Long idProduto,
        String nome,
        CategoryResponseDTO categoria) {

    public static ItemCarrinhoResponseDTO valueOf(ItemCarrinho item) {
        Category category = item.getProduct().getCategory();
        return new ItemCarrinhoResponseDTO(
                item.getQuantidade(),
                item.getPreco(),
                item.getProduct().getId(),
                item.getProduct().getNome(),
                // CategoryResponseDTO.valueOf(item.getProduct().getCategory())
                category != null ? CategoryResponseDTO.valueOf(category) : null
                );
    }

    // public static List<ItemCarrinhoResponseDTO> valueOf(List<ItemCarrinho> item)
    // {
    // return item.stream().map(i -> ItemCarrinhoResponseDTO.valueOf(i)).toList();
    // }

    public static List<ItemCarrinhoResponseDTO> valueOf(List<ItemCarrinho> itens) {
        return itens.stream()
                .map(ItemCarrinhoResponseDTO::valueOf)
                .collect(Collectors.toList());
    }

}
