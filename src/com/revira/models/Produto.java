package com.revira.models;

import java.io.Serializable;
import java.util.List;

public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private String categoria;
    private List<Produto> produtosValidos;

    public Produto(String nome, String categoria, List<Produto> produtosValidos) {
        this.nome = nome;
        this.categoria = categoria;
        this.produtosValidos = produtosValidos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Produto> getProdutosValidos() {
        return produtosValidos;
    }

    public void setProdutosValidos(List<Produto> produtosValidos) {
        this.produtosValidos = produtosValidos;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", produtosValidos=" + produtosValidos +
                '}';
    }
}
