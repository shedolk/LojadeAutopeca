package br.unitins.topicos1.dto;

import java.time.LocalDate;

public record PagamentoDTO(
        LocalDate momento,
        Integer formaPagamento_id) {

}
