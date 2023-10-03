package br.unitins.topicos1.modelo;

import jakarta.persistence.Entity;

@Entity
public class Cupom extends DefaultEntity {
    private String codigo;
    private String novo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
