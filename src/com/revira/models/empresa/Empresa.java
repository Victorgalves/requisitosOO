package com.revira.models.empresa;

import com.revira.models.Endereco;
import com.revira.models.Produto;
import java.io.Serializable;
import java.util.List;

public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String senha;
    private String cnpj;
    private Endereco endereco;
    private List<Produto> produtos;

    public Empresa(String nome,String senha, String cnpj, Endereco endereco, List<Produto> produtos) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.produtos = produtos;
        this.senha=senha;
   }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}