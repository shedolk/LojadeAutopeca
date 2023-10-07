package br.unitins.topicos1.dto;

import br.unitins.topicos1.modelo.Cupom;

public record CupomResponseDTO(
    Long id,
    String codigo
) {
    public static CupomResponseDTO valueOf(Cupom cupom) {
        return new CupomResponseDTO(
            cupom.getId(),
            cupom.getCodigo());
    }
}
