package br.unitins.topicos1.model.converterjpa;

import br.unitins.topicos1.model.FormaPagamento;
import jakarta.persistence.AttributeConverter;

public class FormaPagamentoConverter implements AttributeConverter<FormaPagamento, Integer> {

    @Override
    public Integer convertToDatabaseColumn(FormaPagamento formaPagamento) {
        return (formaPagamento == null ? null : formaPagamento.getId());
    }

    @Override
    public FormaPagamento convertToEntityAttribute(Integer id) {
        return FormaPagamento.valueOf(id);
    }
}
