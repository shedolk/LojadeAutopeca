package br.unitins.topicos1.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class Pagamento extends DefaultEntity {
    Long id;
    LocalDate momento;
    FormaPagamento formaPagamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getMomento() {
        return momento;
    }

    public void setMomento(LocalDate momento) {
        this.momento = momento;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

}
