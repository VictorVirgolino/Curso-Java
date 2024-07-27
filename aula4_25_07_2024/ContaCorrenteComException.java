/*
                   Classes - Atividade 6 Conta Corrente e Cliente
                    Aluno: Victor Arruda Câmara Virgolino
                                  Questão:

		Crias classes Conta Corrente com atributos:
		- numero
		- Cliente
		- saldo
		- data
		e metodos:
		- depositar
		- sacar
		- exibir extrato
		- transferir
		e um método construtor que inicialize os atributos
 */

package sef.module3.sample.aula4_25_07_2024;

import sef.module3.sample.aula3_24_07_2024.ContaCorrente;
import sef.module3.sample.aula4_25_07_2024.erros.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ContaCorrenteComException {
    private int numero;
    private Cliente cliente;
    private double saldo;
    private LocalDate data;

    //construtor
    public ContaCorrenteComException(int numero, Cliente cliente, double saldo, LocalDate data){
        this.cliente = cliente;
        this.numero = numero;
        this.saldo = saldo;
        this.data = data;
    }
    /*
     * Método para adicionar um valor ao saldo da conta
     * */
    public double depositar(double valor) throws Exception{
        try{
            if(valor < 0){
                throw new DepositoInvalidoException(valor);
            }else{
                this.saldo += valor;
                return this.saldo;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            return this.saldo;
        }
    }
    /*
     * Método para sacar um valor do saldo da conta
     * */
    public double sacar(double valor) throws Exception{
        //checar se tem saldo para sacar
        try{
            if(valor < 0){
                throw new SaqueInvalidoException(valor);
            }else{
                if(this.saldo < valor){
                    throw new EstouroSaqueException(valor, this.saldo);
                }else{
                    this.saldo -= valor;
                    return this.saldo;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return  this.saldo;
        }
    }
    /*
     * Método para visualizar valor atual do saldo da conta
     * */
    public String exibirExtrato(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = this.data.format(formatter);
        String mensagem = "O cliente %s, de numero %d, com conta aberta em %s \nPossui saldo no valor de R$%.2f".formatted(this.cliente.getNome(),this.numero,dataFormatada,this.saldo );
        System.out.println(mensagem);
        return mensagem;
    }
    /*
     * Método transferir retira um valor do saldo da conta e transfere para outra conta
     * */
    public double transferir(ContaCorrenteComException destino, double valor) throws Exception{
        try{
            if(valor <0){
                throw new TransferenciaInvalidaException(valor);
            }
            else if(this.saldo < valor){
                throw new EstouroTransferenciaException(valor, this.saldo);
            }
            else{
                this.saldo -= valor;
                destino.depositar(valor);
                return this.saldo;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return this.saldo;
        }


    }
}
