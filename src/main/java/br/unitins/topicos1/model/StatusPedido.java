package br.unitins.topicos1.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StatusPedido {

    AGUARDANDO_PAGAMENTO(1, "Aguardando pagamento"),
    PAGAMENTO_APROVADO(2, "Pagamento aprovado"),
    EM_SEPARACAO(3, "Em separação"),
    ENVIADO(4, "Enviado"),
    ENTREGA(5, "Entrega"),
    CANCELADO(6, "Cancelado");

    private final Integer id;
    private final String label;

    StatusPedido(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static StatusPedido valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for (StatusPedido statusPedido : StatusPedido.values()) {
            if (statusPedido.getId().equals(id))
                return statusPedido;
        }
        throw new IllegalArgumentException("Id inválido" + id);
    }
}
