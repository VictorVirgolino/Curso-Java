package sef.module3.sample.aula4_25_07_2024.erros;

public class EstouroSaqueException extends Exception {

    public EstouroSaqueException(double saque, double saldo){
        super(String.format("Estouro no Saque: Valor do Saque maior que o saldo da conta\n Saldo: R$: %.2f , Saque: R$: %.2f", saldo, saque));
    }
}
