package br.unitins.topicos1.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum FormaPagamento {

    PIX(1, "Pix"),
    CARTAO_CREDITO(2, "Cartão de credito"),
    CARTAO_DEBITO(3, "Cartão de debito");

    private final Integer id;
    private final String label;

    FormaPagamento(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static FormaPagamento valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for (FormaPagamento formaPagamento : FormaPagamento.values()) {
            if (formaPagamento.getId().equals(id))
                return formaPagamento;
        }
        throw new IllegalArgumentException("Id inválido" + id);
    }
}
