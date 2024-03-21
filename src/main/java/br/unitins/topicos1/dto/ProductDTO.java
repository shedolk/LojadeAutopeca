package br.unitins.topicos1.dto;

import java.util.List;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProductDTO(

        @NotBlank(message = "O campo nome deve ser informado.") @Size(max = 60, message = "O campo nome deve possuir no máximo 60 caracteres.") String nome,
        String descricao,
        @NotNull Long idCategory,
        Double preco,
        Integer estoque,
        String nomeImagem,
        List<ItemPedidoDTO> itemPedidos) {

}
