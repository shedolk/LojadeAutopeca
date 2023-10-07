package br.unitins.topicos1.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;

public class Cliente extends DefaultEntity {
    @Column(length = 60)
    private String nome;

    @Column(length = 250)
    private String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "cliente_endereco", joinColumns = @JoinColumn(name = "id_cliente")
    ,inverseJoinColumns = @JoinColumn(name = "id_endereco"))
    private List<Endereco> endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }

}
