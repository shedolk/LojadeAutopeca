package br.unitins.topicos1.dto;

import java.util.List;

public record MarcaDTO(
    String nome,
    String descricao,
    List<ProdutoDTO> listaProduto
) {
    
}
