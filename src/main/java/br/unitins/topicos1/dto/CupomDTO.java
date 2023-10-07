package br.unitins.topicos1.dto;

import br.unitins.topicos1.modelo.Cupom;

public record CupomDTO(
        Long id,
        String codigo) {
            
    public static CupomDTO valueOf(Cupom cupom) {
        return new CupomDTO(
                cupom.getId(),
                cupom.getCodigo());
    }
}