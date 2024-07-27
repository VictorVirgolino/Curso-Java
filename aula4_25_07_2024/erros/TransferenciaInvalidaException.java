package sef.module3.sample.aula4_25_07_2024.erros;

public class TransferenciaInvalidaException extends Exception {

    public TransferenciaInvalidaException(double transferencia){
        super(String.format("Transferência Invalida: Tentativa de Transferir Valor Negativo R$: %.2f", transferencia));
    }
}
