package br.unitins.topicos1.dto;

import java.time.LocalDate;

import br.unitins.topicos1.model.Cupom;

public record CupomDTO

(

        String nomeCupom,
        LocalDate dataAplicada,
        Double desconto) {
    public static CupomDTO valueOf(Cupom cupom) {
        return new CupomDTO(
                cupom.getNomeCupom(),
                cupom.getDataAplicada(),
                cupom.getDesconto());
    }
}
