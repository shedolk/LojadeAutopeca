package br.unitins.topicos1.dto;

import java.time.LocalDate;

import br.unitins.topicos1.model.Cupom;

public record CupomResponseDTO(
        Long id,
        String nomeCupom,
        LocalDate dataAplicada,
        Double desconto) {
    public static CupomResponseDTO valueOf(Cupom cupom) {
        return new CupomResponseDTO(
                cupom.getId(),
                cupom.getNomeCupom(),
                cupom.getDataAplicada(),
                cupom.getDesconto());
    }
}
