package br.unitins.topicos1.model;

import java.time.LocalDate;

public class Cupom {
    Long id;
    String nomeCupom;
    LocalDate dataAplicada;
    Double desconto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCupom() {
        return nomeCupom;
    }

    public void setNomeCupom(String nomeCupom) {
        this.nomeCupom = nomeCupom;
    }

    public LocalDate getDataAplicada() {
        return dataAplicada;
    }

    public void setDataAplicada(LocalDate dataAplicada) {
        this.dataAplicada = dataAplicada;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

}
