/*
                   Array Manipulation - Atividade 3 LocalizarNúmero
                    Aluno: Victor Arruda Câmara Virgolino
                                  Questão:

		Implemente um jogo da velha com 2 jogadores, no qual os jogadores vão
		se alternando fazendo jogadas e quando algum jogador ganhar, imprima
		"Jogador x ganhou parabéns!", em caso de empate imprima "O jogo terminou em Empate".
		Após imprimir o resultado feche o programa.
 */
package sef.module3.sample.aula2_23_07_2024;

import java.util.Scanner;

public class JogoDaVelha {
		
	public static void main(String[] args) {
		String[][] tabuleiro = { 
						{" "," "," "},
						{" "," "," "},
						{" "," "," "}};

		Scanner scanner = new Scanner(System.in);
		int status_jogo;
		char jogador = '1';

		imprimirTabuleiro(tabuleiro);
		do {
			realizarJogada(jogador,tabuleiro, scanner);
			status_jogo = checarGanhador(tabuleiro);
			imprimirTabuleiro(tabuleiro);
			jogador = (jogador == '1') ? '2' : '1';
		} while (status_jogo == 0);

		scanner.close();

	}


	/*
	* Função para imprimir o estado atual do tabuleiro
	* */
	private static void imprimirTabuleiro(String[][] tabuleiro_atual){
		System.out.print("\n\n 0   1    2\n\n");
		for (int posicao1 = 0; posicao1 < 3; posicao1++) {
			for (int posicao2 = 0; posicao2 < 3; posicao2++) {
				System.out.print(" " + tabuleiro_atual[posicao1][posicao2]);
				if (posicao2 < 2) {
					System.out.print(" | ");
				}
				if (posicao2 == 2) {
					System.out.print("  " + posicao1);
				}
			}
			if (posicao1 < 2) {
				System.out.print("\n------------");
			}
			System.out.println("\n");
		}
	}

	/*
	* Função que realiza as jogadas dos jogadores no tabuleiro
	*
	* recebe como parametros:
	*    char jogador - '1' ou '2'
	*    String[][] tabuleiro_atual - recebe o tabuleiro antes da jogada
	*	 Scanner scanner - scanner para realizar a captura de dados do usuario
	*
	* */
	private static void realizarJogada(char jogador, String[][] tabuleiro_atual, Scanner scanner){
		int coluna, linha;
		boolean posicaoValida = false;

		System.out.printf("Jogador %c sua vez de jogar\n", jogador);

		//Deve perguntar a posicao da jogada até ser dado um posicao valida
		do{
			System.out.println("Digite a coluna que deseja realizar a jogada (0-2):");
			linha = scanner.nextInt();
			System.out.println("Digite a linha que deseja realizar a jogada (0-2):");
			coluna = scanner.nextInt();

			if(coluna < 0 || coluna > 2 || linha < 0 || linha > 2){
				System.out.println("Posição inválida. Por favor, escolha uma posição entre 0 e 2.");
			}else if(!tabuleiro_atual[linha][coluna].equals(" ")){
				System.out.println("Posição já ocupada. Por favor, escolha outra posição.");
			}else{
				posicaoValida = true;
				tabuleiro_atual[linha][coluna] = jogador == '1' ? "X" : "O";
			}
		}while(!posicaoValida);
	}

	/*
	* Função para verifica se algum jogador ganhou o jogo com base no estado atual do tabuleiro, ou se houve empate
	* retorna 0 se o jogo ainda está em andamento, 1 se jogador 1 ganhou , 2 se jogador 2 ganhou ou 3 se foi empate.
	*
	* parametros:
	* 	String[][] tabuleiro_atual - estado do tabuleiro após a a ultima jogada
	*
	*retorno:
	* 	int status (0-3):
	* 		0 - Jogo em andamento
	*  		1 - Jogador 1 ganhou
	* 		2 - Jogador 2 ganhou
	* 		3 - Empate
	*
	* */
	private static int checarGanhador(String [][] tabuleiro_atual){
		String ganhador;

		//verificar as linhas
		for(int i = 0; i < 3; i++){
			if(!tabuleiro_atual[i][0].equals(" ") && tabuleiro_atual[i][0].equals(tabuleiro_atual[i][1]) && tabuleiro_atual[i][0].equals(tabuleiro_atual[i][2])){
				ganhador = tabuleiro_atual[i][0].equals("X") ? "1" : "2";
				System.out.printf("Jogador %s ganhou, Parabéns", ganhador);
				return Integer.parseInt(ganhador);
			}
		}

		//verificar colunas
		for(int j = 0; j < 3; j++){
			if(!tabuleiro_atual[0][j].equals(" ") && tabuleiro_atual[0][j].equals(tabuleiro_atual[1][j]) && tabuleiro_atual[0][j].equals(tabuleiro_atual[2][j])){
				ganhador = tabuleiro_atual[j][0].equals("X") ? "1" : "2";
				System.out.printf("Jogador %s ganhou, Parabéns", ganhador);
				return Integer.parseInt(ganhador);
			}
		}

		//verificar diagonais
		if(!tabuleiro_atual[0][0].equals(" ") && tabuleiro_atual[0][0].equals(tabuleiro_atual[1][1]) && tabuleiro_atual[0][0].equals(tabuleiro_atual[2][2])) {
			ganhador = tabuleiro_atual[0][0].equals("X") ? "1" : "2";
			System.out.printf("Jogador %s ganhou, Parabéns", ganhador);
			return Integer.parseInt(ganhador);
		}

		if(!tabuleiro_atual[0][2].equals(" ") && tabuleiro_atual[0][2].equals(tabuleiro_atual[1][1]) && tabuleiro_atual[0][2].equals(tabuleiro_atual[2][0])) {
			ganhador = tabuleiro_atual[0][2].equals("X") ? "1" : "2";
			System.out.printf("Jogador %s ganhou, Parabéns", ganhador);
			return Integer.parseInt(ganhador);
		}

		//verificar se o tabuleiro está completo
		for(int x = 0; x < 3; x++){
			for(int y = 0; y < 3; y++){
				if(tabuleiro_atual[x][y].equals(" ")){
					return 0;
				}
			}
		}

		//O tabuleiro está completo e nenhum jogador ganhou
		System.out.println("Não há mais jogadas possíveis, Empate!");
		return 3;


	}
}
