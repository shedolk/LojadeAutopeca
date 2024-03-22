package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Product;

public record ProductResponseDTO(

        Long id,
        String nome,
        String descricao,
        CategoryResponseDTO category,
        Double preco,
        Integer estoque,
        String nomeImagem) {

    public static ProductResponseDTO valueOf(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getNome(),
                product.getDescricao(),
                CategoryResponseDTO.valueOf(product.getCategory()),
                product.getPreco(),
                product.getEstoque(),
                product.getNomeImagem());
    }
}
