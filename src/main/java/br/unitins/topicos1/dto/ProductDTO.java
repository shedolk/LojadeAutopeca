package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProductDTO(

                @NotBlank(message = "O campo nome deve ser informado.") @Size(max = 60, message = "O campo nome deve possuir no máximo 60 caracteres.") String nome,
                String descricao,
                Long idCategory,
                Double preco,
                Integer estoque,
                String nomeImagem) {

        public static ProductDTO valueOf(Product product) {
                return new ProductDTO(
                                product.getNome(),
                                product.getDescricao(),
                                product.getCategory().getId(),
                                product.getPreco(),
                                product.getEstoque(),
                                product.getNomeImagem());
        }

}
