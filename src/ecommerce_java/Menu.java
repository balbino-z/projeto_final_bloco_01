package ecommerce_java;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import ecommerce_java.util.Cores;

public class Menu {

    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        
        int opcao;

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
            System.out.println("                 6 - Sair                            ");
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

            if (opcao == 6) {
                System.out.println("\nObrigado por visitar nosso E-commerce de Camisas de Futebol!");
                sobre();
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println("\nCatálogo Completo\n");
                    // falta implementar a acao concreta
                    keyPress();
                    break;

                case 2:
                    System.out.println("\nCamisas de Times do Brasileirão\n");
                    // falta implementar a acao concreta
                    keyPress();
                    break;

                case 3:
                    System.out.println("\nBuscar Produto por Nome\n");
                    // Aqui vamos implementar a função de buscar produtos por nome na próxima etapa
                    keyPress();
                    break;

                case 4:
                    System.out.println("\nCamisas Retrô\n");
                    // Aqui vamos implementar a função de listar camisas retrô na próxima etapa
                    keyPress();
                    break;

                case 5:
                    System.out.println("\nCamisas de Times da La Liga\n");
                    // Aqui vamos implementar a função de listar camisas da La Liga na próxima etapa
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