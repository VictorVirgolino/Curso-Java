/*
                   Classes - Atividade 6 Conta Corrente e Cliente
                    Aluno: Victor Arruda Câmara Virgolino
                                  Questão:

		Crias classes Conta Corrente com atributos:
		- nome
		- cpf
		- sobrenome
		e um método construtor que inicialize os atributos
 */
package sef.module3.sample.aula4_25_07_2024;

public class Cliente {
    private String nome;
    private String cpf;
    private String sobrenome;

    public Cliente(String nome, String cpf, String sobrenome) {
        this.nome = nome;
        this.cpf = cpf;
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSobrenome() {
        return sobrenome;
    }
}
