package br.unitins.topicos1.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class Pedido extends DefaultEntity {
    private String codigo;
    private LocalDate date;
    private List<ItemPedido> itemPedido;
    private Endereco endereco;
    private Cliente cliente;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<ItemPedido> getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(List<ItemPedido> itemPedido) {
        this.itemPedido = itemPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
