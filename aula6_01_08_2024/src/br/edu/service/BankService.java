package sef.module3.sample.aula6_01_08_2024.src.br.edu.service;

import java.util.List;

import sef.module3.sample.aula6_01_08_2024.src.br.edu.entities.Account;
import sef.module3.sample.aula6_01_08_2024.src.br.edu.entities.Client;


public interface BankService {
	public List<Account> listAccounts();
	public List<Client> listClients();
}
