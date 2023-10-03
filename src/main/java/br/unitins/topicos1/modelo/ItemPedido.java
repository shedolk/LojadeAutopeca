package br.unitins.topicos1.modelo;

import jakarta.persistence.Entity;

@Entity
public class ItemPedido extends DefaultEntity {
    private int quantidade;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
