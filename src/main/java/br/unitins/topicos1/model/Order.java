package br.unitins.topicos1.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_table")
public class Order extends DefaultEntity{
    
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "order")
    private List<ItemCarrinho> itens;

    private Double totalPedido;

    
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    
    public Usuario getUsuario() {
        return usuario;
    }

    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Double getTotalPedido() {
        return totalPedido;
    }

    
    public void setTotalPedido(Double totalPedido) {
        this.totalPedido = totalPedido;
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public void setItens(List<ItemCarrinho> itens) {
        this.itens = itens;
    }

}
