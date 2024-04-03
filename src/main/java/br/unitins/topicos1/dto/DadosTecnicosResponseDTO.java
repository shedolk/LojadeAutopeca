package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.DadosTecnicos;

public record DadosTecnicosResponseDTO(

        Long id,

        String compatibilidade,

        String tipoMola,

        String tipoAmortecedor,

        String fornecedor,

        String embalagem,

        String peso) {
    public static DadosTecnicosResponseDTO valueOf(DadosTecnicos dadosTecnicos) {

        if (dadosTecnicos == null)
            return null;

        return new DadosTecnicosResponseDTO(
                dadosTecnicos.getId(),
                dadosTecnicos.getCompatibilidade(),
                dadosTecnicos.getTipoMola(),
                dadosTecnicos.getTipoAmortecedor(),
                dadosTecnicos.getFornecedor(),
                dadosTecnicos.getEmbalagem(),
                dadosTecnicos.getPeso());
    }
}
