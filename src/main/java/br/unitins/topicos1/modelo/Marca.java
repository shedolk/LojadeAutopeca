package br.unitins.topicos1.modelo;

import java.util.List;

public class Marca extends DefaultEntity {
    
    private String nome;
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "marca_produto",
        joinColumns = @JoinColumn(name = "id_marca"),
        inverseJoinColumns = @JoinColumn(name = "id_produto"))
    private List<Produto> listaProduto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(List<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    
}
