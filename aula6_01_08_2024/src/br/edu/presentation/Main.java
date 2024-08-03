




package sef.module3.sample.aula6_01_08_2024.src.br.edu.presentation;

import sef.module3.sample.aula6_01_08_2024.src.br.edu.entities.Address;
import sef.module3.sample.aula6_01_08_2024.src.br.edu.service.BankService;
import sef.module3.sample.aula6_01_08_2024.src.br.edu.service.ServiceFactory;
import sef.module3.sample.aula6_01_08_2024.src.br.edu.entities.Account;
import sef.module3.sample.aula6_01_08_2024.src.br.edu.entities.AccountEnum;
import sef.module3.sample.aula6_01_08_2024.src.br.edu.entities.Client;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * OBSERVAÇÕES: 
 * NÃO é permitido o uso de nenhuma estrutura de repetição (for, while, do-while).
 * Tente, ao máximo, evitar o uso das estruturas if, else if, else e switch-case
 * 
 */
/*
                          Streams - Atividade  Streams
                    Aluno: Victor Arruda Câmara Virgolino
                                  Questão:

		Completar as funções restantes e testar as funcionalidades utilizando apenas Streams
 */
public class Main {

	private static BankService service = ServiceFactory.getService();

	public static void main(String[] args) {
		//TO test here
		// Complete o código aqui
		//Criar os Endereços
		Address address1 = new Address("Rua Floriano Peixoto", 10, "Apto 1002", "Paraíba", "Brazil");
		Address address2 = new Address("Rua Epaminondas Macaxeira", 50, "", "Paraíba", "Brazil");
		Address address3 = new Address("Worth  Street ", 169, "", "New York", "United States");
		Address address4 = new Address("77th Road", 120, "", "New York", "United States");

		//Criar os clientes
		Client client1 = new Client("Ze Mane", "zemane@gmail.com", address1);
		Client client2 = new Client("Maria Silva", "mariasilva@gmail.com", address2);
		Client client3 = new Client("John Steward", "johnsteward@gmail.com", address3);
		Client client4 = new Client("Ann Adams", "annadams@gmail.com", address4);

		//Criar as Contas
		Account account1 = new Account(1, 1, 1000.0, client1, AccountEnum.SAVING);
		Account account2 = new Account(1, 2, 2000.0, client1, AccountEnum.JOINT);
		Account account3 = new Account(1, 3, 4000.0, client2, AccountEnum.CHECKING);
		Account account4 = new Account(1, 4, 8000.0, client2, AccountEnum.SAVING);
		Account account5 = new Account(2, 5, 1000.0, client3, AccountEnum.JOINT);
		Account account6 = new Account(2, 6, 2000.0, client3, AccountEnum.CHECKING);
		Account account7 = new Account(2, 7, 2000.0, client4, AccountEnum.JOINT);

		//Associando as contas aos clientes
		List<Account> accountsClient1 = new ArrayList<>();
		accountsClient1.add(account1);
		accountsClient1.add(account2);

		List<Account> accountsClient2 = new ArrayList<>();
		accountsClient2.add(account3);
		accountsClient2.add(account4);

		List<Account> accountsClient3 = new ArrayList<>();
		accountsClient3.add(account5);
		accountsClient3.add(account6);

		List<Account> accountsClient4 = new ArrayList<>();
		accountsClient4.add(account7);

		client1.setAccounts(accountsClient1);
		client2.setAccounts(accountsClient2);
		client3.setAccounts(accountsClient3);
		client4.setAccounts(accountsClient4);


		List<Client> clients = Arrays.asList(client1, client2, client3, client4);
		List<Account> accounts = Arrays.asList(account1, account2, account3, account4, account5, account6, account7);

		//Variáveis
		List<String> estados;
		int[] numeros;
		double saldo, somatorio;
		List<Account> jointaccounts;
		String[] emails;
		boolean ehPrimo;
		int fatorial;

				//Mockando o Bank Service
		service = new BankService() {
			@Override
			public List<Client> listClients() {
				return clients;
			}

			@Override
			public List<Account> listAccounts() {
				return accounts;
			}
		};



		//testando os Métodos

		//1. Testando imprimirNomesClientes
		System.out.println("1. ImprimirNomesClientes: ");
		imprimirNomesClientes();

		//2. Testando imprimirMediaSaldos
		System.out.println("2. ImprimirMediaSaldos: ");
		imprimirMediaSaldos();

		//3. Testando imprimirPaisClienteMaisRico
		System.out.println("3. ImprimirPaisClienteMaisRico: ");
		imprimirPaisClienteMaisRico();

		//4. Testando imprimirSaldoMedio
		System.out.println("4. ImprimirSaldoMédio(Agencia): ");
		imprimirSaldoMedio(1);

		//5. Testando imprimirClientesComPoupanca
		System.out.println("5. ImprimirClientesComPoupanca: ");
		imprimirClientesComPoupanca();

		//6. Testando getEstadoClientes
		System.out.println("6. GetEstadoClientes: ");
		estados = getEstadoClientes(1);
		System.out.println(estados);

		//7. Testando getNumerosContas
		System.out.println("7. GetNumerosContas: ");
		numeros = getNumerosContas("Brazil");
		System.out.println(Arrays.toString(numeros));

		//8. Testando getMaiorSaldo
		System.out.println("8. GetMaiorSaldo: ");
		saldo = getMaiorSaldo(client2.getEmail());
		System.out.println(saldo);

		//9. Testando sacar
		System.out.println("9. Sacar: ");
		sacar(1,account1.getNumber(), 100);

		//10. Testando depositar
		System.out.println("10. Depositar: ");
		depositar("Brazil", 200);

		//11. Testando transferir
		System.out.println("11. Transferir: ");
		transferir(1, account3.getNumber(), account6.getNumber(), 150);

		//12. Testando getContasConjuntas
		System.out.println("12. GetContasConjuntas: ");
		jointaccounts = getContasConjuntas(clients);
		jointaccounts.forEach(System.out::println);

		//13. Testando getSomaContasEstado
		System.out.println("13. GetSomaContasEstado: ");
		somatorio = getSomaContasEstado("Paraíba");
		System.out.println(somatorio);

		//14. Testando getEmailsClientesContasConjuntas
		System.out.println("14. GetEmailsClientesContasConjuntas: ");
		emails = getEmailsClientesContasConjuntas();
		System.out.println(Arrays.toString(emails));

		//15. Testando isPrimo
		System.out.println("15. IsPrimo(7): ");
		ehPrimo = isPrimo(7);
		System.out.println(ehPrimo);

		//16. Testando getFatorial
		System.out.println("16. GetFatorial(3): ");
		fatorial = getFatorial(3);
		System.out.println(fatorial);


	}

	/**
	 * 1. Imprima na tela o nome e e-mail de todos os clientes (sem repetição), usando o seguinte formato:
	 * Ze Mane - ze@mail.br
	 */
	public static void imprimirNomesClientes() {
		service
		.listClients()
		.stream()
		.map(cliente -> cliente.getName() +" - "+ cliente.getEmail())
		.distinct()
		.forEach(System.out::println);
	}

	/**
	 * 2. Imprima na tela o nome do cliente e a média do saldo de suas contas, ex:
	 * Ze Mane - 352
	 */
	public static void imprimirMediaSaldos() {
		service
		.listClients()
		.stream()
		.forEach(cliente -> {
			double media = 
					service
					.listAccounts()
					.stream()
					.filter(conta -> conta.getClient().getName().equals(cliente.getName()))
					.mapToDouble(conta -> conta.getBalance())
					.average()
					.getAsDouble();
			
			System.out.println(cliente.getName() + " - " + media);
		});
	}

	/**
	 * 3. Considerando que só existem os países "Brazil" e "United States", 
	 * imprima na tela qual deles possui o cliente mais rico, ou seja,
	 * com o maior saldo somando todas as suas contas.
	 */
	public static void imprimirPaisClienteMaisRico() {
		double sumClientBrazil = 
				service
				.listAccounts()
				.stream()
				.filter(conta -> conta.getClient().getAddress().getCountry().equals("Brazil"))
				.mapToDouble(conta -> conta.getBalance())
				.sum();
		double sumClienteUSA = 
				service
				.listAccounts()
				.stream()
				.filter(conta -> conta.getClient().getAddress().getCountry().equals("United States"))
				.mapToDouble(conta -> conta.getBalance())
				.sum();

		System.out.println(Double.compare(sumClientBrazil, sumClienteUSA));

	}

	/**
	 * 4. Imprime na tela o saldo médio das contas da agência
	 * @param agency
	 */
	public static void imprimirSaldoMedio(int agency) {	
		double average = 
				service
				.listAccounts()
				.stream()
				.filter(conta -> conta.getAgency() == agency)
				.mapToDouble(conta -> conta.getBalance())
				.average()
				.getAsDouble();
		System.out.println(average);

	}

	/**
	 * 5. Imprime na tela o nome de todos os clientes que possuem conta poupança (tipo SAVING)
	 */
	public static void imprimirClientesComPoupanca() {
		// Complete o código aqui
		service
				.listClients()
				.stream()
				.filter(cliente -> cliente.getAccounts()
						.stream()
						.anyMatch(conta -> conta.getType() == AccountEnum.SAVING))
				.map(Client::getName)
				.forEach(System.out::println);
	}

	/**
	 * 6.
	 * @param agency
	 * @return Retorna uma lista de Strings com o "estado" de todos os clientes da agência
	 */
	public static List<String> getEstadoClientes(int agency) {
		List<String> stateOfAllClients = 
				service
				.listAccounts()
				.stream()
				.filter(conta -> conta.getAgency() == agency)
				.map(conta -> conta.getClient().getAddress().getState())
				.distinct()
				.collect(Collectors.toList());
		return (List<String>) stateOfAllClients;
	}

	/**
	 * 7.
	 * @param country
	 * @return Retorna uma lista de inteiros com os números das contas daquele país
	 */
	public static int[] getNumerosContas(String country) {
		int [] countryNumbers =
				service
						.listAccounts()
						.stream()
						.filter(conta -> conta.getClient()
								.getAddress()
								.getCountry().equals(country))
						.mapToInt(Account::getNumber)
						.toArray();


		return (int[]) countryNumbers;
	}

	/**
	 * 8.
	 * Retorna o somatório dos saldos das contas do cliente em questão 
	 * @param clientEmail
	 * @return
	 */
	public static double getMaiorSaldo(String clientEmail) {
		double sumBalance =
				service
				.listAccounts()
				.stream()
				.filter(conta -> conta.getClient().getEmail().equals(clientEmail))
				.mapToDouble(conta -> conta.getBalance())
				.sum();
		return sumBalance;
	}

	/**
	 * 9.
	 * Realiza uma operação de saque na conta de acordo com os parâmetros recebidos
	 * @param agency
	 * @param number
	 * @param value
	 */
	public static void sacar(int agency, int number, double value) {
		service
		.listAccounts()
		.stream()
		.filter(conta -> conta.getAgency( )== agency &&
						conta.getNumber() == number)
		.map(conta -> conta.getBalance() - value);
	}

	/**
	 * 10. Realiza um deposito para todos os clientes do país em questão	
	 * @param country
	 * @param value
	 */
	public static void depositar(String country, double value) {
		service
		.listAccounts()
		.stream()
		.filter(conta -> conta.getClient().getAddress().getCountry().equals(country))
		.map(conta -> conta.getBalance() + value);
	}

	/**
	 * 11. Realiza uma transferência entre duas contas de uma agência.
	 * @param agency - agência das duas contas
	 * @param numberSource - conta a ser debitado o dinheiro
	 * @param numberTarget - conta a ser creditado o dinheiro
	 * @param value - valor da transferência
	 */
	public static void transferir(int agency, int numberSource, int numberTarget, double value) {
		service
		.listAccounts()
		.stream()
		.filter(conta -> conta.getAgency() == agency &&
						conta.getNumber() == numberSource)
		.map(conta -> conta.getBalance() - value);
		service
		.listAccounts()
		.stream()
		.filter(conta -> conta.getAgency() == agency &&
						conta.getNumber() == numberTarget)
		.map(conta -> conta.getBalance() + value);
	}

	/**
	 * 12.
	 * @param clients
	 * @return Retorna uma lista com todas as contas conjuntas (JOINT) dos clientes
	 */
	public static List<Account> getContasConjuntas(List<Client> clients) {
		List<Account> jointAccounts = new ArrayList<Account>();
		// Complete o código aqui
		clients
				.forEach(cliente -> cliente
						.getAccounts()
						.stream()
						.filter(conta -> conta.getType() == AccountEnum.JOINT)
						.forEach(jointAccounts::add));
		return jointAccounts;
	}

	/**
	 * 13.
	 * @param state
	 * @return Retorna uma lista com o somatório dos saldos de todas as contas do estado 
	 */
	public static double getSomaContasEstado(String state) {
		double sumAccountState =
				service
				.listAccounts()
				.stream()
				.filter(conta -> conta.getClient().getAddress().getState().equals(state))
				.mapToDouble(conta -> conta.getBalance())
				.sum();
		return sumAccountState;
	}

	/**
	 * 14.
	 * @return Retorna um array com os e-mails de todos os clientes que possuem contas conjuntas
	 */
	public static String[] getEmailsClientesContasConjuntas() {
		List<String> emailsAllClientsJoinAccounts =
				service
				.listClients()
				.stream()
				.filter(cliente -> cliente.getAccounts().stream().anyMatch(conta -> conta.getType() == AccountEnum.JOINT))
				.map(Client::getEmail)
				.toList();
		return emailsAllClientsJoinAccounts.toArray(new String[0]);
				
	}

	/**
	 * 15.
	 * @param number
	 * @return Retorna se o número é primo ou não
	 */
	public static boolean isPrimo(int number) {
		return IntStream
				.rangeClosed(2, (number/2))
				.noneMatch(i -> number % i==0);
	}

	/**
	 * 16.
	 * @param number
	 * @return Retorna o fatorial do número
	 */
	public static int getFatorial(int number) {
		int factorial =
				IntStream.rangeClosed(1, number)
				.reduce(1, (x,y) -> x*y);
		return factorial;
	}
}
