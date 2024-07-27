package sef.module3.sample.aula4_25_07_2024;

import sef.module3.sample.aula4_25_07_2024.erros.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Victor", "093.110.374-60", "Arruda Câmara Virgolino");
        Cliente cliente2 = new Cliente("Maria", "123.456.789-00", "Silva");

        LocalDate dataAbertura = LocalDate.now();

        // Criar contas correntes com saldo inicial
        ContaCorrenteComException conta1 = new ContaCorrenteComException(12345, cliente1, 1000.0, dataAbertura);
        ContaCorrenteComException conta2 = new ContaCorrenteComException(54321, cliente2, 200.0, dataAbertura);

        // Teste de depósito com valor negativo
        try {
            conta1.depositar(-500.0);
        } catch (DepositoInvalidoException e) {
            System.out.println("Exceção capturada no depósito: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exceção inesperada no depósito: " + e.getMessage());
        }

        // Teste de saque com valor negativo
        try {
            conta1.sacar(-100.0);
        } catch (SaqueInvalidoException e) {
            System.out.println("Exceção capturada no saque: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exceção inesperada no saque: " + e.getMessage());
        }

        // Teste de saque com valor maior que o saldo
        try {
            conta1.sacar(1500.0);
        } catch (EstouroSaqueException e) {
            System.out.println("Exceção capturada no saque: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exceção inesperada no saque: " + e.getMessage());
        }

        // Teste de transferência com valor negativo
        try {
            conta1.transferir(conta2, -100.0);
        } catch (TransferenciaInvalidaException e) {
            System.out.println("Exceção capturada na transferência: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exceção inesperada na transferência: " + e.getMessage());
        }

        // Teste de transferência com valor maior que o saldo
        try {
            conta1.transferir(conta2, 2000.0);
        } catch (EstouroTransferenciaException e) {
            System.out.println("Exceção capturada na transferência: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exceção inesperada na transferência: " + e.getMessage());
        }

        // Teste de depósito válido
        try {
            conta1.depositar(500.0);
            System.out.println("Depósito bem-sucedido. Saldo atual: " + conta1.exibirExtrato());
        } catch (Exception e) {
            System.out.println("Exceção inesperada no depósito válido: " + e.getMessage());
        }

        // Teste de saque válido
        try {
            conta1.sacar(200.0);
            System.out.println("Saque bem-sucedido. Saldo atual: " + conta1.exibirExtrato());
        } catch (Exception e) {
            System.out.println("Exceção inesperada no saque válido: " + e.getMessage());
        }

        // Teste de transferência válida
        try {
            conta1.transferir(conta2, 300.0);
            System.out.println("Transferência bem-sucedida. Saldo conta1: " + conta1.exibirExtrato());
            System.out.println("Saldo conta2: " + conta2.exibirExtrato());
        } catch (Exception e) {
            System.out.println("Exceção inesperada na transferência válida: " + e.getMessage());
        }

        // Exibir o extrato final
        conta1.exibirExtrato();
        conta2.exibirExtrato();
    }
}
