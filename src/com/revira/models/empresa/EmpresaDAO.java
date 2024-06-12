package com.revira.models.empresa;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO {
    private CadastroObjetos cadastro;

    public EmpresaDAO(Class<?> tipo) {
        this.cadastro = new CadastroObjetos(tipo);
    }

    public boolean incluir(Empresa empresa) {
        String cnpj = empresa.getCnpj();
        Empresa empresaExistente = buscar(cnpj);
        if (empresaExistente == null) {
            cadastro.incluir(empresa, cnpj);
            System.out.println("Empresa incluída com sucesso!");
            return true;
        } else {
            System.out.println("Erro ao incluir a empresa: Já existe uma empresa com o mesmo CNPJ.");
            return false;
        }
    }

    public void alterar(Empresa empresa) {
        String cnpj = empresa.getCnpj();
        cadastro.alterar(empresa, cnpj);
        System.out.println("Produtos alterados com sucesso!");
    }

    public void excluir(String cnpj) {
        cadastro.excluir(cnpj);
        System.out.println("Empresa excluída com sucesso!");
    }

    public Empresa buscar(String cnpj) {
        return (Empresa) cadastro.buscar(cnpj);
    }


    }