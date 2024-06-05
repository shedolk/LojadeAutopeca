package br.unitins.topicos1.model;

import java.util.ArrayList;
import java.util.List;

//import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario extends DefaultEntity {

    private String nome;

    private String login;

    private String senha;

    private String cpf;

    //@Enumerated(EnumType.STRING)
    private Perfil perfil;

    @OneToMany(mappedBy = "usuario")
    private List<Telefone> listaTelefone = new ArrayList<>();

    // @OneToMany(mappedBy = "usuario")
    // private List<Pedido> pedidos = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Order> orders;

    

    @OneToMany(mappedBy = "usuario")
    private List<Endereco> listaEndereco = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Telefone> getListaTelefone() {
        return listaTelefone;
    }

    public void setListaTelefone(List<Telefone> listaTelefone) {
        this.listaTelefone = listaTelefone;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    // public List<Pedido> getPedidos() {
    //     return pedidos;
    // }

    // public void setPedidos(List<Pedido> pedidos) {
    //     this.pedidos = pedidos;
    // }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Endereco> getListaEndereco() {
        return listaEndereco;
    }

    public void setListaEndereco(List<Endereco> listaEndereco) {
        this.listaEndereco = listaEndereco;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}