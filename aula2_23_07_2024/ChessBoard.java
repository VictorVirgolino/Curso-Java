package sef.module3.sample.aula2_23_07_2024;

public class ChessBoard {
	public static void main(String[] args) {
		
		String[][] board = { 
				{"R","N","B","Q","K","B","N","R"},
				{"P","P","P","P","P","P","P","P"},
				{" "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "},
				{"p","p","p","p","p","p","p","p"},
				{"r","n","b","q","k","b","n","r"}};

		imprimirBoard(board);

		//Mover Cavalo
		System.out.println("");
		System.out.println("Movimentação Cavalo: ");
		System.out.println("");

		validarMovimento("cavalo", 7,6,5,5, board);
		imprimirBoard(board);

		// Mover Peao
		System.out.println("");
		System.out.println("Movimentação Peão: ");
		System.out.println("");

		validarMovimento("peao", 6,2,4,2,board);
		 imprimirBoard(board);

		// Mover Peao2
		System.out.println("");
		System.out.println("Movimentação Peão2: ");
		System.out.println("");

		validarMovimento("peao", 6,1,4,1,board);
		imprimirBoard(board);

		 //Mover Bispo
		System.out.println("");
		System.out.println("Movimentação Bispo: ");
		System.out.println("");

		validarMovimento("bispo", 7,2,5,0,board);
		imprimirBoard(board);

		//Mover Torre
		System.out.println("");
		System.out.println("Movimentação Torre: ");
		System.out.println("");

		validarMovimento("torre", 7,7,7,6,board);
		imprimirBoard(board);

		//Mover Rainha
		System.out.println("");
		System.out.println("Movimentação Rainha: ");
		System.out.println("");

		validarMovimento("rainha", 7,3,5,1,board);
		imprimirBoard(board);

		//Mover Torre
		System.out.println("");
		System.out.println("Movimentação Rei: ");
		System.out.println("");

		validarMovimento("rei", 7,4,7,3,board);
		imprimirBoard(board);


	}

	// --------------Impressão do Tabuleiro---------------------------------------
	public static void imprimirBoard(String[][] board) {
		 for (int i = 0; i < board.length; i++) {
		        for (int j = 0; j < board[i].length; j++) {
		        	System.out.print(board[i][j]+"  ");
		        }
		        System.out.println("");
		    }
	}

	//Função para mover as peças, estou levando em consideração que estamos movendo apenas as peças de representadas por letras minusculas
	public static boolean validarMovimento(String peca, int linha_inicial, int coluna_inicial, int linha_final, int coluna_final,String[][] tabuleiro_atual){

		int deltaLinha, deltaColuna;


		//Verificar se o destino é uma posicao fora do tabuleiro
		if(linha_final < 0 || linha_final >= tabuleiro_atual.length || coluna_inicial < 0 || coluna_final > tabuleiro_atual[0].length){
			System.out.println("Movimento Inválido - Posição de destino fora do tabuleiro.");
			return false;
		}

		//Verificar se a posicao final não está ocupado por outra peça
		if(!tabuleiro_atual[linha_final][coluna_final].equals(" ")){
			System.out.println("Movimento Inválido - Destino final já está ocupado por uma peça.");
			return false;
		}

		//calcular os deltas
		deltaLinha = Math.abs(linha_final - linha_inicial);
		deltaColuna = Math.abs(coluna_final - coluna_inicial);

		switch(peca){
			case "peao":
				//um peão só pode andar para frente e ele pode andar uma ou duas casas
				if (deltaColuna == 0 && (deltaLinha == 1 || (linha_inicial == 6 && deltaLinha == 2))) {
					System.out.println("Movimento válido para um peão");
					moverPeca(linha_inicial, coluna_inicial, linha_final, coluna_final, tabuleiro_atual);
					return true;
				}else{
					System.out.println("Movimento inválido para um peão");
					return false;
				}



			case "torre":
				//uma torre se move quantas casas quiser na mesma coluna ou linha
				if(deltaColuna == 0 || deltaLinha == 0) {
					System.out.println("Movimento válido para uma torre");
					moverPeca(linha_inicial, coluna_inicial, linha_final, coluna_final, tabuleiro_atual);
					return true;
				}else{
					System.out.println("Movimento inválido para uma torre");
					return false;
				}

			case "cavalo":
				//o cavalo se movimenta em formato de l
				if((deltaLinha == 2 && deltaColuna == 1) || (deltaLinha == 1 && deltaColuna == 2)) {
					System.out.println("Movimento válido para um cavalo");
					moverPeca(linha_inicial, coluna_inicial, linha_final, coluna_final, tabuleiro_atual);
					return true;
				}else{
					System.out.println("Movimento inválido para um cavalo");
					return false;
				}

			case "bispo":
				//um bispo pode se mover quantas casas quiser nas diagonais
				if(deltaColuna == deltaLinha){
					System.out.println("Movimento válido para um bispo");
					moverPeca(linha_inicial, coluna_inicial, linha_final, coluna_final, tabuleiro_atual);
					return true;
				}else{
					System.out.println("Movimento inválido para um bispo");
					return false;
				}


			case "rainha":
				//a rainha pode ser mover como uma torre ou como um bispo
				if((deltaColuna == deltaLinha) || deltaColuna == 0 || deltaLinha == 0){
					System.out.println("Movimento válido para um bispo");
					moverPeca(linha_inicial, coluna_inicial, linha_final, coluna_final, tabuleiro_atual);
					return true;
				}else{
					System.out.println("Movimento inválido para um bispo");
					return false;
				}

			case "rei":
				if((deltaColuna == 1 || deltaColuna == 0) && (deltaLinha == 0 || deltaLinha == 1)) {
					System.out.println("Movimento válido para um rei");
					moverPeca(linha_inicial, coluna_inicial, linha_final, coluna_final, tabuleiro_atual);
					return true;
				}else{
					System.out.println("Movimento inválido para um rei");
					return false;
				}

			case null, default:
				System.out.println("Tipo de Peça inválida");
				return false;
		}

	}

	public static void moverPeca(int linha_inicial, int coluna_inicial, int linha_final, int coluna_final,String[][] tabuleiro_atual){
		tabuleiro_atual[linha_final][coluna_final] = tabuleiro_atual[linha_inicial][coluna_inicial];
		tabuleiro_atual[linha_inicial][coluna_inicial] = " ";
	}
}
