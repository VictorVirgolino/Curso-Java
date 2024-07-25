/*
                       Scanners - Atividade 1 Stadium
                    Aluno: Victor Arruda Câmara Virgolino
                                  Questão:

Um estádio oferece três categorias de assentos:
    * Classe A - R$ 50
    * Classe B - R$ 30
    * Classe C - R$ 20
 Escreva um programa que pergunta quantos bilhetes de cada classe foram vendidos,
 e, em seguida, exibe a reda gerada pela venda dos ingressos.
 */
package sef.module3.sample.aula1_22_07_2024;


import java.util.Scanner;

public class Stadium {
    public static void main(String[] args) {

        //Declara o Scanner para perguntar os valores dos ingressos
        Scanner scanner = new Scanner(System.in);

        //Pergunta a quantidade de bilhetes da classe A vendidos
        System.out.println("Quantos bilhetes da Classe A foram vendidos?");
        int classeA = scanner.nextInt();

        //Pergunta a quantidade de bilhetes da classe B vendidos
        System.out.println("Quantos bilhetes da Classe B foram vendidos?");
        int classeB = scanner.nextInt();

        //Pergunta a quantidade de bilhetes da classe C vendidos
        System.out.println("Quantos bilhetes da Classe C foram vendidos?");
        int classeC = scanner.nextInt();

        // Calcular a Renda
        int renda = (50 * classeA) + (30 * classeB) + (20 * classeC);

        //Imprime o valor final da renda da venda dos ingressos
        System.out.printf("A renda gerada pela venda dos ingressos foi de R$ %d", renda);




    }
}
