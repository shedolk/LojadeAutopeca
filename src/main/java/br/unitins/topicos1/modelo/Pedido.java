package br.unitins.topicos1.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

public class Pedido extends DefaultEntity {

    @Column(length = 60)
    private String codigo;

    private LocalDate date;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "pedido_itemPedido", joinColumns = @JoinColumn(name = "id_pedido"),
     inverseJoinColumns = @JoinColumn(name = "id_itemPedido"))
    private List<ItemPedido> itemPedido;

    @OneToOne
    @JoinTable(name = "pedido_endereco", joinColumns = @JoinColumn(name = "id_pedido"),
     inverseJoinColumns = @JoinColumn(name = "id_endereco"))
    private List<Endereco> Endereco;

    @OneToOne
    @JoinTable(name = "pedido_cliente", joinColumns = @JoinColumn(name = "id_pedido"),
     inverseJoinColumns = @JoinColumn(name = "id_cliente"))
    private List<Cliente> cliente;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

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

    public List<Endereco> getEndereco() {
        return Endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        Endereco = endereco;
    }

    public List<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }

}
