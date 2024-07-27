package sef.module3.sample.aula4_25_07_2024.erros;

public class SaqueInvalidoException extends Exception {

    public SaqueInvalidoException(double saque){
        super(String.format("Saque Invalido: Tentativa de Sacar Valor Negativo R$: %.2f", saque));
    }
}
