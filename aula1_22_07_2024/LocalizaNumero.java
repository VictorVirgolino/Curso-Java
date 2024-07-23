package sef.module3.sample.aula1_22_07_2024;
/*
                   Scanners - Atividade 2 LocalizarNúmero
                    Aluno: Victor Arruda Câmara Virgolino
                                  Questão:

		Faça um programa para pesquisar o valor 8 no vetor dado:
		inteiro vetor[] = {1, 3, 5, 8, 9, 10}
 */



public class LocalizaNumero {
	// Corrigir este algoritmo.
	public static void main(String[] args) {
		int vetor[] = {1,2,3,4,5,6,7,8,9,10};
		int numero = 8;
		boolean achou = false;
		int indice = -1;
		
		for (int i=0; i<10; i++) {
			if (vetor[i] == numero){
				indice = i;
				achou = true;
				break;
		    }
		}
		if (achou) {
	        System.out.println("Achei");
	        System.out.printf("Na Posição %d está localizado do numero %d.", indice, vetor[indice]);
		}
	}

}
