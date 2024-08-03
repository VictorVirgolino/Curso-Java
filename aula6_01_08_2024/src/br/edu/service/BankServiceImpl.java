package sef.module3.sample.aula6_01_08_2024.src.br.edu.service;

import java.util.List;

import sef.module3.sample.aula6_01_08_2024.src.br.edu.entities.Account;
import sef.module3.sample.aula6_01_08_2024.src.br.edu.entities.Client;
import sef.module3.sample.aula6_01_08_2024.src.br.edu.helper.LoadEntities;

public class BankServiceImpl implements BankService {

	protected BankServiceImpl() { }
	
	@Override
	public List<Account> listAccounts() {
		return LoadEntities.ACCOUNTS;
	}

	@Override
	public List<Client> listClients() {
		return LoadEntities.CLIENTS;
	}
	
}
