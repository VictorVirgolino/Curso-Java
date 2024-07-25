/*
                   Array Manipulation - Atividade 8 Jogo de Xadrez com JOptionPane
                    Aluno: Victor Arruda Câmara Virgolino
                                  Questão:

		Simule as movimentações de peças de xadrez em um tabuleiro e valide as entradas de dados.
 */
package sef.module3.sample.aula3_24_07_2024;

import javax.swing.*;

public class XadrezPane {
    public static void main(String[] args) {
        String[][] board = {
                {"R","N","B","Q","K","B","N","R"},
                {"P","P","P","P","P","P","P","P"},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {"p","p","p","p","p","p","p","p"},
                {"r","n","b","q","k","b","n","r"}
        };

        imprimirBoard(board);

        // Mover Cavalo
        mostrarMensagem("Movimentação Cavalo: ");
        validarMovimento("cavalo", 7, 6, 5, 5, board);
        imprimirBoard(board);

        // Mover Peão
        mostrarMensagem("Movimentação Peão: ");
        validarMovimento("peao", 6, 2, 4, 2, board);
        imprimirBoard(board);

        // Mover Peão2
        mostrarMensagem("Movimentação Peão2: ");
        validarMovimento("peao", 6, 1, 4, 1, board);
        imprimirBoard(board);

        // Mover Bispo
        mostrarMensagem("Movimentação Bispo: ");
        validarMovimento("bispo", 7, 2, 5, 0, board);
        imprimirBoard(board);

        // Mover Torre
        mostrarMensagem("Movimentação Torre: ");
        validarMovimento("torre", 7, 7, 7, 6, board);
        imprimirBoard(board);

        // Mover Rainha
        mostrarMensagem("Movimentação Rainha: ");
        validarMovimento("rainha", 7, 3, 5, 1, board);
        imprimirBoard(board);

        // Mover Rei
        mostrarMensagem("Movimentação Rei: ");
        validarMovimento("rei", 7, 4, 7, 3, board);
        imprimirBoard(board);
    }

    // --------------Impressão do Tabuleiro---------------------------------------
    public static void imprimirBoard(String[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]).append("  ");
            }
            sb.append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Tabuleiro", JOptionPane.INFORMATION_MESSAGE);
    }

    // Função para mostrar mensagens
    public static void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Mensagem", JOptionPane.INFORMATION_MESSAGE);
    }

    // Função para validar movimento das peças
    public static boolean validarMovimento(String peca, int linhaInicial, int colunaInicial, int linhaFinal, int colunaFinal, String[][] tabuleiroAtual) {
        int deltaLinha, deltaColuna;

        // Verificar se o destino é uma posição fora do tabuleiro
        if (linhaFinal < 0 || linhaFinal >= tabuleiroAtual.length || colunaInicial < 0 || colunaFinal >= tabuleiroAtual[0].length) {
            JOptionPane.showMessageDialog(null, "Movimento Inválido - Posição de destino fora do tabuleiro.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Verificar se a posição final não está ocupada por outra peça
        if (!tabuleiroAtual[linhaFinal][colunaFinal].equals(" ")) {
            JOptionPane.showMessageDialog(null, "Movimento Inválido - Destino final já está ocupado por uma peça.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Calcular os deltas
        deltaLinha = Math.abs(linhaFinal - linhaInicial);
        deltaColuna = Math.abs(colunaFinal - colunaInicial);

        switch (peca) {
            case "peao":
                // Um peão só pode andar para frente e ele pode andar uma ou duas casas
                if (deltaColuna == 0 && (deltaLinha == 1 || (linhaInicial == 6 && deltaLinha == 2))) {
                    JOptionPane.showMessageDialog(null, "Movimento válido para um peão", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    moverPeca(linhaInicial, colunaInicial, linhaFinal, colunaFinal, tabuleiroAtual);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Movimento inválido para um peão", "Erro", JOptionPane.ERROR_MESSAGE);
                    return false;
                }

            case "torre":
                // Uma torre se move quantas casas quiser na mesma coluna ou linha
                if (deltaColuna == 0 || deltaLinha == 0) {
                    JOptionPane.showMessageDialog(null, "Movimento válido para uma torre", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    moverPeca(linhaInicial, colunaInicial, linhaFinal, colunaFinal, tabuleiroAtual);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Movimento inválido para uma torre", "Erro", JOptionPane.ERROR_MESSAGE);
                    return false;
                }

            case "cavalo":
                // O cavalo se movimenta em formato de L
                if ((deltaLinha == 2 && deltaColuna == 1) || (deltaLinha == 1 && deltaColuna == 2)) {
                    JOptionPane.showMessageDialog(null, "Movimento válido para um cavalo", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    moverPeca(linhaInicial, colunaInicial, linhaFinal, colunaFinal, tabuleiroAtual);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Movimento inválido para um cavalo", "Erro", JOptionPane.ERROR_MESSAGE);
                    return false;
                }

            case "bispo":
                // Um bispo pode se mover quantas casas quiser nas diagonais
                if (deltaColuna == deltaLinha) {
                    JOptionPane.showMessageDialog(null, "Movimento válido para um bispo", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    moverPeca(linhaInicial, colunaInicial, linhaFinal, colunaFinal, tabuleiroAtual);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Movimento inválido para um bispo", "Erro", JOptionPane.ERROR_MESSAGE);
                    return false;
                }

            case "rainha":
                // A rainha pode se mover como uma torre ou como um bispo
                if ((deltaColuna == deltaLinha) || deltaColuna == 0 || deltaLinha == 0) {
                    JOptionPane.showMessageDialog(null, "Movimento válido para uma rainha", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    moverPeca(linhaInicial, colunaInicial, linhaFinal, colunaFinal, tabuleiroAtual);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Movimento inválido para uma rainha", "Erro", JOptionPane.ERROR_MESSAGE);
                    return false;
                }

            case "rei":
                if ((deltaColuna == 1 || deltaColuna == 0) && (deltaLinha == 0 || deltaLinha == 1)) {
                    JOptionPane.showMessageDialog(null, "Movimento válido para um rei", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    moverPeca(linhaInicial, colunaInicial, linhaFinal, colunaFinal, tabuleiroAtual);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Movimento inválido para um rei", "Erro", JOptionPane.ERROR_MESSAGE);
                    return false;
                }

            default:
                JOptionPane.showMessageDialog(null, "Tipo de Peça inválida", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
        }
    }

    public static void moverPeca(int linhaInicial, int colunaInicial, int linhaFinal, int colunaFinal, String[][] tabuleiroAtual) {
        tabuleiroAtual[linhaFinal][colunaFinal] = tabuleiroAtual[linhaInicial][colunaInicial];
        tabuleiroAtual[linhaInicial][colunaInicial] = " ";
    }
}
