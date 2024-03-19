package br.unitins.topicos1.dto;

import java.time.LocalDate;

import br.unitins.topicos1.model.FormaPagamento;
import br.unitins.topicos1.model.Pagamento;

public record PagamentoResponseDTO(
        Long id,
        LocalDate momento,
        FormaPagamento formaPagamento) {
    public static PagamentoResponseDTO valueOf(Pagamento pagamento) {
        return new PagamentoResponseDTO(
                pagamento.getId(),
                pagamento.getMomento(),
                pagamento.getFormaPagamento());
    }

}
