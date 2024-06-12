package com.revira.utils;


public class Utils {

    public static boolean validadorCpf(String cpf) {
        return cpf != null && cpf.length() == 11;
    }

    public static boolean validadorCnpj(String cnpj) {
        return cnpj != null && cnpj.length() == 14;
    }

    public static boolean validadorCep(String cep) {
        return cep != null && cep.length() == 8;
    }
}