package sef.module3.sample.aula4_25_07_2024.erros;

public class DepositoInvalidoException extends Exception{

    public DepositoInvalidoException(double valor){
        super(String.format("Deposito Invalido: Tentativa de Depositar Valor Negativo R$: %.2f", valor));
    }
}
