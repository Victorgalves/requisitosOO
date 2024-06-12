package com.revira.models.empresa;


import com.revira.models.Endereco;
import com.revira.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class EmpresaMediator {
    private EmpresaDAO empresaDAO;

    public EmpresaMediator(Class<?> tipo) {
        this.empresaDAO = new EmpresaDAO(tipo);
    }

    public boolean incluirEmpresa(String nome, String senha, String cnpj, Endereco endereco) {
        if (!Utils.validadorCnpj(cnpj)) {
            System.out.println("Erro ao incluir a empresa: CNPJ inválido.");
            return false;
        }

        Empresa empresa = new Empresa(nome, senha, cnpj, endereco, new ArrayList<>());
        return empresaDAO.incluir(empresa);
    }

    public void alterar(Empresa empresa) {
        String cnpj = empresa.getCnpj();
        empresaDAO.alterar(empresa);

    }

    public Empresa buscar(String cnpj) {
        return (Empresa) empresaDAO.buscar(cnpj);
    }


    public void excluirEmpresa(String cnpj) {
        empresaDAO.excluir(cnpj);
    }
}
