package br.unitins.topicos1.modelo;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Pagamento  {
    
    CREDITO(1, "Credito"),
    PIX(2, "Pix"),
    BOLETO(3,"Boleto");

    private final Integer id;
    private final String formaPagamento;

    Pagamento(Integer id, String formaPagamento) {
        this.id = id;
        this.formaPagamento = formaPagamento;
    }

    public Integer getId() {
        return id;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public static Pagamento valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for (Pagamento pagamento : Pagamento.values()) {
            if (pagamento.getId().equals(id))
                return pagamento;
        }
        throw new IllegalArgumentException("Id inválido" + id);
    }
}
