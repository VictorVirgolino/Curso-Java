/*
             Array Manipulation - Atividade 7 Refazer Jogo da Velha com JOptionPane
                    Aluno: Victor Arruda Câmara Virgolino
                                  Questão:

		Implemente um jogo da velha com 2 jogadores, no qual os jogadores vão
		se alternando fazendo jogadas e quando algum jogador ganhar, imprima
		"Jogador x ganhou parabéns!", em caso de empate imprima "O jogo terminou em Empate".
		Após imprimir o resultado feche o programa.
 */
package sef.module3.sample.aula3_24_07_2024;

import javax.swing.JOptionPane;

public class JogoDaVelhaPane {

	public static void main(String[] args) {
		String[][] tabuleiro = {
				{" "," "," "},
				{" "," "," "},
				{" "," "," "}
		};

		int statusJogo;
		char jogador = '1';

		imprimirTabuleiro(tabuleiro);
		do {
			realizarJogada(jogador, tabuleiro);
			statusJogo = checarGanhador(tabuleiro);
			imprimirTabuleiro(tabuleiro);
			jogador = (jogador == '1') ? '2' : '1';
		} while (statusJogo == 0);
	}

	private static void imprimirTabuleiro(String[][] tabuleiroAtual) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\n 0   1   2\n\n");
		for (int posicao1 = 0; posicao1 < 3; posicao1++) {
			for (int posicao2 = 0; posicao2 < 3; posicao2++) {
				sb.append(" ").append(tabuleiroAtual[posicao1][posicao2]);
				if (posicao2 < 2) {
					sb.append(" | ");
				}
				if (posicao2 == 2) {
					sb.append("  ").append(posicao1);
				}
			}
			if (posicao1 < 2) {
				sb.append("\n------------");
			}
			sb.append("\n");
		}
		JOptionPane.showMessageDialog(null, sb.toString(), "Tabuleiro", JOptionPane.INFORMATION_MESSAGE);
	}

	private static void realizarJogada(char jogador, String[][] tabuleiroAtual) {
		int coluna, linha;
		boolean posicaoValida = false;

		do {
			String mensagem = String.format("Jogador %c, sua vez de jogar\nDigite a coluna (0-2):", jogador);
			linha = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
			mensagem = "Digite a linha (0-2):";
			coluna = Integer.parseInt(JOptionPane.showInputDialog(mensagem));

			if (coluna < 0 || coluna > 2 || linha < 0 || linha > 2) {
				JOptionPane.showMessageDialog(null, "Posição inválida. Escolha uma posição entre 0 e 2.", "Erro", JOptionPane.ERROR_MESSAGE);
			} else if (!tabuleiroAtual[linha][coluna].equals(" ")) {
				JOptionPane.showMessageDialog(null, "Posição já ocupada. Escolha outra posição.", "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				posicaoValida = true;
				tabuleiroAtual[linha][coluna] = jogador == '1' ? "X" : "O";
			}
		} while (!posicaoValida);
	}

	private static int checarGanhador(String[][] tabuleiroAtual) {
		String ganhador;

		// Verificar linhas
		for (int i = 0; i < 3; i++) {
			if (!tabuleiroAtual[i][0].equals(" ") && tabuleiroAtual[i][0].equals(tabuleiroAtual[i][1]) && tabuleiroAtual[i][0].equals(tabuleiroAtual[i][2])) {
				ganhador = tabuleiroAtual[i][0].equals("X") ? "1" : "2";
				JOptionPane.showMessageDialog(null, "Jogador " + ganhador + " ganhou, Parabéns!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
				return Integer.parseInt(ganhador);
			}
		}

		// Verificar colunas
		for (int j = 0; j < 3; j++) {
			if (!tabuleiroAtual[0][j].equals(" ") && tabuleiroAtual[0][j].equals(tabuleiroAtual[1][j]) && tabuleiroAtual[0][j].equals(tabuleiroAtual[2][j])) {
				ganhador = tabuleiroAtual[0][j].equals("X") ? "1" : "2";
				JOptionPane.showMessageDialog(null, "Jogador " + ganhador + " ganhou, Parabéns!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
				return Integer.parseInt(ganhador);
			}
		}

		// Verificar diagonais
		if (!tabuleiroAtual[0][0].equals(" ") && tabuleiroAtual[0][0].equals(tabuleiroAtual[1][1]) && tabuleiroAtual[0][0].equals(tabuleiroAtual[2][2])) {
			ganhador = tabuleiroAtual[0][0].equals("X") ? "1" : "2";
			JOptionPane.showMessageDialog(null, "Jogador " + ganhador + " ganhou, Parabéns!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
			return Integer.parseInt(ganhador);
		}

		if (!tabuleiroAtual[0][2].equals(" ") && tabuleiroAtual[0][2].equals(tabuleiroAtual[1][1]) && tabuleiroAtual[0][2].equals(tabuleiroAtual[2][0])) {
			ganhador = tabuleiroAtual[0][2].equals("X") ? "1" : "2";
			JOptionPane.showMessageDialog(null, "Jogador " + ganhador + " ganhou, Parabéns!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
			return Integer.parseInt(ganhador);
		}

		// Verificar se o tabuleiro está completo
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (tabuleiroAtual[x][y].equals(" ")) {
					return 0;
				}
			}
		}

		// O tabuleiro está completo e nenhum jogador ganhou
		JOptionPane.showMessageDialog(null, "Não há mais jogadas possíveis, Empate!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
		return 3;
	}
}
