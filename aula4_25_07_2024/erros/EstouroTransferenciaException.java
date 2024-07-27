package sef.module3.sample.aula4_25_07_2024.erros;

public class EstouroTransferenciaException extends Exception {

    public EstouroTransferenciaException(double transferencia, double saldo){
        super(String.format("Estouro na Transferência: Valor da Transferência maior que o saldo da conta\n Saldo: R$: %.2f , Transferência: R$: %.2f", saldo, transferencia));
    }
}
