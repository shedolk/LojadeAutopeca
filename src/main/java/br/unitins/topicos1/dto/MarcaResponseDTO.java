package br.unitins.topicos1.dto;

import java.util.List;

import br.unitins.topicos1.modelo.Marca;

public record MarcaResponseDTO(
    Long id,
    String nome,
    String descricao,
    List<ProdutoDTO> produtos
 ) {
    public static MarcaResponseDTO valueOf(Marca marca){

        return new MarcaResponseDTO(
            marca.getId(),
            marca.getNome(),
            marca.getDescricao(),
            marca.getListaProduto()
            .stream().
            map(t -> ProdutoDTO.valueOf(t)).toList()
        );
    }

}