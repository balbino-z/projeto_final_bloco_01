package ecommerce_java;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import ecommerce_java.controller.ProdutoController;
import ecommerce_java.model.Camisa;
import ecommerce_java.model.CamisaRetro;
import ecommerce_java.model.Produto;
import ecommerce_java.util.Cores;

public class Menu {

    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        
        ProdutoController produtos = new ProdutoController();
        
        int opcao, tipo, id = 0;
        String nome, time, liga, tamanho, anoLancamento;
        float preco;

        // cadastro alguns produtos para teste
        produtos.cadastrar(new Camisa(produtos.gerarId(), "Camisa Flamengo 2023", "Flamengo", "Brasileirão", "M", 299.90f));
        produtos.cadastrar(new Camisa(produtos.gerarId(), "Camisa Corinthians 2023", "Corinthians", "Brasileirão", "G", 279.90f));
        produtos.cadastrar(new CamisaRetro(produtos.gerarId(), "Camisa Brasil 1994", "Seleção Brasil", "Copa do Mundo", "M", 399.90f, "1994"));
        produtos.cadastrar(new CamisaRetro(produtos.gerarId(), "Camisa Argentina 1986", "Seleção Argentina", "Copa do Mundo", "P", 359.90f, "1986"));
        produtos.cadastrar(new Camisa(produtos.gerarId(), "Camisa Barcelona 2023", "Barcelona", "La Liga", "G", 349.90f));
        produtos.cadastrar(new Camisa(produtos.gerarId(), "Camisa Real Madrid 2023", "Real Madrid", "La Liga", "M", 349.90f));

        while (true) {
            System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND + "*****************************************************");
            System.out.println("                    THG IMPORTS                      ");
            System.out.println("             SUA LOJA DE CAMISAS DE FUTEBOL          ");
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("                 1 - Ver Catálogo Completo           ");
            System.out.println("                 2 - Camisas do Brasileirão          ");
            System.out.println("                 3 - Buscar Produto por Nome         ");
            System.out.println("                 4 - Camisas Retrô                   ");
            System.out.println("                 5 - Camisas da La Liga              ");
            System.out.println("                 6 - Cadastrar Novo Produto          ");
            System.out.println("                 7 - Atualizar Produto               ");
            System.out.println("                 8 - Remover Produto                 ");
            System.out.println("                 9 - Sair                            ");
            System.out.println("*****************************************************");
            System.out.println("                                                     " + Cores.TEXT_RESET);
            System.out.print("Entre com a opção desejada: ");

            try {
                opcao = leia.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nDigite valores inteiros!");
                leia.nextLine();
                opcao = 0;
            }

            if (opcao == 9) {
                System.out.println("\nObrigado por visitar nosso E-commerce de Camisas de Futebol!");
                sobre();
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println("\nCatálogo Completo\n");
                    produtos.listarTodos();
                    keyPress();
                    break;

                case 2:
                    System.out.println("\nCamisas de Times do Brasileirão\n");
                    produtos.consultarPorLiga("Brasileirão");
                    keyPress();
                    break;

                case 3:
                    System.out.println("\nBuscar Produto por Nome\n");
                    System.out.print("Digite o nome do produto: ");
                    leia.nextLine();
                    nome = leia.nextLine();
                    produtos.consultarPorNome(nome);
                    keyPress();
                    break;

                case 4:
                    System.out.println("\nCamisas Retrô\n");
                    produtos.listarCamisasRetro();
                    keyPress();
                    break;

                case 5:
                    System.out.println("\nCamisas de Times da La Liga\n");
                    produtos.consultarPorLiga("La Liga");
                    keyPress();
                    break;
                    
                case 6:
                    System.out.println("\nCadastrar Novo Produto\n");
                    
                    System.out.println("Digite o tipo de produto (1-Camisa Normal / 2-Camisa Retrô): ");
                    tipo = leia.nextInt();
                    
                    System.out.print("Digite o nome do produto: ");
                    leia.nextLine();
                    nome = leia.nextLine();
                    
                    System.out.print("Digite o nome do time: ");
                    time = leia.nextLine();
                    
                    System.out.print("Digite o nome da liga: ");
                    liga = leia.nextLine();
                    
                    System.out.print("Digite o tamanho da camisa (P/M/G): ");
                    tamanho = leia.nextLine();
                    
                    System.out.print("Digite o preço do produto: ");
                    try {
                        preco = leia.nextFloat();
                        
                        if (tipo == 1) {
                            produtos.cadastrar(new Camisa(produtos.gerarId(), nome, time, liga, tamanho, preco));
                        } else if (tipo == 2) {
                            System.out.print("Digite o ano de lançamento da camisa retrô: ");
                            leia.nextLine();
                            anoLancamento = leia.nextLine();
                            produtos.cadastrar(new CamisaRetro(produtos.gerarId(), nome, time, liga, tamanho, preco, anoLancamento));
                        } else {
                            System.out.println("Tipo de produto inválido!");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("\nErro: Digite um valor numérico para o preço!");
                        leia.nextLine();
                    }
                    
                    keyPress();
                    break;
                    
                case 7:
                    System.out.println("\nAtualizar Produto\n");
                    
                    try {
                        System.out.print("Digite o ID do produto que deseja atualizar: ");
                        id = leia.nextInt();
                        
                        // verifica se o produto existe
                        Produto produtoAtual = produtos.buscarPorId(id);
                        
                        if (produtoAtual != null) {
                            System.out.println("\nProduto encontrado:");
                            produtoAtual.visualizar();
                            
                            // verifica o tipo do produto (1-Camisa, 2-CamisaRetro)
                            tipo = produtos.verificarTipo(id);
                            
                            System.out.print("\nDigite o nome do produto: ");
                            leia.nextLine();
                            nome = leia.nextLine();
                            
                            System.out.print("Digite o nome do time: ");
                            time = leia.nextLine();
                            
                            System.out.print("Digite o nome da liga: ");
                            liga = leia.nextLine();
                            
                            System.out.print("Digite o tamanho da camisa (P/M/G): ");
                            tamanho = leia.nextLine();
                            
                            System.out.print("Digite o preço do produto: ");
                            preco = leia.nextFloat();
                            
                            if (tipo == 1) {
                                produtos.atualizar(new Camisa(id, nome, time, liga, tamanho, preco));
                            } else if (tipo == 2) {
                                System.out.print("Digite o ano de lançamento da camisa retrô: ");
                                leia.nextLine();
                                anoLancamento = leia.nextLine();
                                produtos.atualizar(new CamisaRetro(id, nome, time, liga, tamanho, preco, anoLancamento));
                            }
                        } else {
                            System.out.println("\nProduto com ID: " + id + " não foi encontrado.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("\nErro: Digite um valor válido!");
                        leia.nextLine();
                    }
                    
                    keyPress();
                    break;
                    
                case 8:
                    System.out.println("\nRemover Produto\n");
                    
                    try {
                        System.out.print("Digite o ID do produto que deseja remover: ");
                        id = leia.nextInt();
                        
                        // verifica se o produto existe antes de tentar remover
                        Produto produtoAtual = produtos.buscarPorId(id);
                        
                        if (produtoAtual != null) {
                            System.out.println("\nProduto encontrado:");
                            produtoAtual.visualizar();
                            
                            System.out.print("\nConfirmar exclusão? (S/N): ");
                            leia.nextLine();
                            String confirmacao = leia.nextLine();
                            
                            if (confirmacao.equalsIgnoreCase("S")) {
                                produtos.deletar(id);
                            } else {
                                System.out.println("\nOperação de exclusão cancelada.");
                            }
                        } else {
                            System.out.println("\nProduto com ID: " + id + " não foi encontrado.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("\nErro: Digite um ID válido (número inteiro)!");
                        leia.nextLine();
                    }
                    
                    keyPress();
                    break;

                default:
                    System.out.println("\nOpção Inválida!\n");
                    keyPress();
                    break;
            }
        }
    }

    public static void sobre() {
        System.out.println("\n******************************************************************");
        System.out.println("E-commerce THG Imports desenvolvido por: Vinicius Balbino Barreto ");
        System.out.println("GitHub: https://github.com/balbino-z");
        System.out.println("******************************************************************");
    }

    public static void keyPress() {
        try {
            System.out.println("\nPressione Enter para continuar...");
            System.in.read();
        } catch (IOException e) {
            System.out.println("Erro de leitura do teclado");
        }
    }
}