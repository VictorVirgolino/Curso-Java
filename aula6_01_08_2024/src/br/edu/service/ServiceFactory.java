package sef.module3.sample.aula6_01_08_2024.src.br.edu.service;

public class ServiceFactory {

	public static BankService getService() {
		return new BankServiceImpl();
	}
}
