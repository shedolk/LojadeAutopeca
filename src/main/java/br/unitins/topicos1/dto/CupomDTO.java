package br.unitins.topicos1.dto;

import br.unitins.topicos1.modelo.Cupom;

public record  CupomDTO( 
    String codigo
    ) {
    public static CupomDTO valueOf(Cupom cupom){
        return new CupomDTO(
            cupom.getCodigo()
        );
    }
}
