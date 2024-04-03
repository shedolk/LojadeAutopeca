package br.unitins.topicos1.model;

import jakarta.persistence.Entity;

@Entity
public class DadosTecnicos extends DefaultEntity {
    
    private String compatibilidade;

    private String tipoMola;

    private String tipoAmortecedor;

    private String fornecedor;

    private String embalagem;

    private String peso;
    
    public String getCompatibilidade() {
        return compatibilidade;
    }

    public void setCompatibilidade(String compatibilidade) {
        this.compatibilidade = compatibilidade;
    }

    public String getTipoMola() {
        return tipoMola;
    }

    public void setTipoMola(String tipoMola) {
        this.tipoMola = tipoMola;
    }

    public String getTipoAmortecedor() {
        return tipoAmortecedor;
    }

    public void setTipoAmortecedor(String tipoAmortecedor) {
        this.tipoAmortecedor = tipoAmortecedor;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    
}
