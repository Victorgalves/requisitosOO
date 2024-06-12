package com.revira.models.empresa;

import com.revira.models.Endereco;
import com.revira.models.Produto;

import java.util.List;
import java.util.Scanner;

public class TelaEmpresa {

    public static void inicializaTelaEmpresa(){
        EmpresaMediator empresaMediator = new EmpresaMediator(Empresa.class);
        Scanner scanner = new Scanner(System.in);

        int escolha;
        do {
            System.out.println("\nMENU:");
            System.out.println("1. Incluir Empresa");
            System.out.println("2. Alterar Empresa");
            System.out.println("3. Buscar Empresa");
            System.out.println("4. Excluir Empresa");

            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    incluirEmpresa(empresaMediator, scanner);
                    break;
                case 2:
                    alterarEmpresa(empresaMediator, scanner);
                    break;
                case 3:
                    buscarEmpresa(empresaMediator, scanner);
                    break;
                case 4:
                    excluirEmpresa(empresaMediator, scanner);

                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (escolha != 0);
    }

    private static void incluirEmpresa(EmpresaMediator empresaMediator, Scanner scanner) {
        System.out.print("Nome da Empresa: ");
        String nome = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("CNPJ da Empresa: ");
        String cnpj = scanner.nextLine();
        System.out.print("cep: ");
        String cep = scanner.nextLine();

        System.out.print("cidade: ");
        String cidade = scanner.nextLine();

        System.out.print("logradouro: ");
        String logradouro = scanner.nextLine();

        System.out.print("bairro: ");
        String bairro = scanner.nextLine();

        System.out.println("Número: ");
        int numero= scanner.nextInt();
        Endereco endereco = new Endereco(cep,cidade,logradouro,bairro,numero);

        empresaMediator.incluirEmpresa(nome, senha, cnpj, endereco);
    }

    private static void alterarEmpresa(EmpresaMediator empresaMediator, Scanner scanner) {
        System.out.print("CNPJ da Empresa a ser alterada: ");
        String cnpj = scanner.nextLine();
        Empresa empresaRecuperada = empresaMediator.buscar(cnpj);

        if (empresaRecuperada != null) {
            List<Produto> produtos = empresaRecuperada.getProdutos();

            System.out.println("Produtos atuais da empresa:");
            for (int i = 0; i < produtos.size(); i++) {
                System.out.println((i + 1) + ". " + produtos.get(i));
            }

            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Remover produto");
            System.out.println("3. Voltar ao menu principal");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do novo produto: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Categoria do novo produto: ");
                    String novaCategoria = scanner.nextLine();
                    produtos.add(new Produto(novoNome, novaCategoria, null));
                    break;
                case 2:
                    System.out.print("Índice do produto a ser removido: ");
                    int indice = scanner.nextInt();
                    scanner.nextLine();
                    if (indice > 0 && indice <= produtos.size()) {
                        produtos.remove(indice - 1);
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }

            empresaRecuperada.setProdutos(produtos);
            empresaMediator.alterar(empresaRecuperada);
        } else {
            System.out.println("Empresa não encontrada.");
        }
    }

    private static void buscarEmpresa(EmpresaMediator empresaMediator, Scanner scanner) {
        System.out.print("CNPJ da Empresa a ser buscada: ");
        String cnpj = scanner.nextLine();
        Empresa empresaRecuperada = empresaMediator.buscar(cnpj);

        if (empresaRecuperada != null) {
            System.out.println("Nome: " + empresaRecuperada.getNome());
            System.out.println("Endereço: " + empresaRecuperada.getEndereco());
            System.out.println("Produtos: " + empresaRecuperada.getProdutos());
        } else {
            System.out.println("Empresa não encontrada na persistência.");
        }
    }


    private static void excluirEmpresa(EmpresaMediator empresaMediator, Scanner scanner) {
        System.out.print("CNPJ da Empresa a ser excluída: ");
        String cnpj = scanner.nextLine();
        empresaMediator.excluirEmpresa(cnpj);
    }
}
