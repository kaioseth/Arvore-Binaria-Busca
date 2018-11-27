/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import java.util.Scanner;
import javax.swing.JOptionPane;

import Estruturas.ABB;
import Estruturas.NoArvore;

/**
 *
 * @author kaio_
 */

public class Main {
    public static Scanner entrada = new Scanner(System.in); // responsável por ler os valores digitados pelo usuário

    private static  ABB abb; // declaro uma árvore binária de busca para realizar operações
    private static int opcao = 1; // utilizada para rodar menu de opções
    private static int valor; // utilizada para receber inteiros de inserção na árvore

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        abb.inicializa();

        while( opcao != 0 ){ // opção 0 indica que deseja encerrar execução
            menuOpcoes(); // mostra menu principal de seleção de operações a serem realizadas na árvore

            opcao = entrada.nextInt(); // lê qual ação deseja realizar

            if( opcao == 1 ){ // Imprime a estrutura completa
                abb.imprimir();
            }else if( opcao == 2 ){ // Insere novo nó e depois realiza balanceamento da árvore - ou para direita ou para equerda
                System.out.println("Digite o valor que deseja inserir: ");
                valor = entrada.nextInt();
                NoArvore noarvore = abb.getRaizPrincipal();
                abb.setAlturaModificada(false);
                abb.inserirRecursivamente(noarvore, valor);
            }else if( opcao == 3 ){ // Remove um valor da árvore
                System.out.println("Digite o valor que deseja remover: ");
                valor = entrada.nextInt();
                NoArvore noarvore = abb.getRaizPrincipal();
                abb.removerRecursivamente(noarvore,valor);
            }else if( opcao == 4 ){ // Buscar valor na estrutura árvore
                System.out.println("Digite o valor que deseja buscar: ");
                valor = entrada.nextInt();
                NoArvore noarvore = abb.getRaizPrincipal();
                abb.buscarRecursivamente(noarvore,valor);
                if( noarvore != null ){
                    System.out.println("O valor informado foi encontrado na estrutura!");
                }else{
                    System.out.println("O valor informado não foi encontrado na estrutura!");
                }
            }
        }

        System.out.println("Execução encerrada!"); // mensagem indicando ao usuário que execução se ecerrou
    }

    // menu para usuário selecionar qual operação de árvore deseja executar
    public static void menuOpcoes(){
        System.out.println("\n");
        System.out.println("# Menu de Opções ---------------------- #");
        System.out.println(" Selecione uma estrutura para manipular: ");
        System.out.println(" 1 - Imprimir árvore ");
        System.out.println(" 2 - Inserir um novo nó ");
        System.out.println(" 3 - Remover um nó ");
        System.out.println(" 4 - Buscar valor em algum dos nós da árvore ");
        System.out.println(" 0 - Encerrar execução ");
        System.out.println("# ------------------------------------- #");
        System.out.println("\n");
    }
}