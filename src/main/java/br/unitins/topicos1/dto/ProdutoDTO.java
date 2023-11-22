package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Produto;

public record ProdutoDTO(
    String nome,
    String descricao,
    Double preco,
    Integer estoque
) {
    public static ProdutoDTO valueOf(Produto produto){
        return new ProdutoDTO(
            produto.getNome(),
            produto.getDescricao(),
            produto.getPreco(),
            produto.getEstoque()
            );
    }
}
