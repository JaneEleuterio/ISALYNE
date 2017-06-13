package utils;

/**
 * Classe que retorna os valores da transferência bancária.
 * @author Avatar
 *
 */
public class BankTransfer {

	private static String bank;
	
	private static String name;
	
	private static String number;
	
	private static String agency;
	
	private static String cpf;
	
	public static void initBankTransfer() {
		bank = "Banco Ficticio";
		
		name = "José Augusto";
		
		number = "142567-50";
		
		agency = "4356";
		
		cpf = "648.489.389-50";
	}
	
	public static String getBank() {
		return bank;
	}
	
	public static String getName() {
		return name;
	}
	
	public static String getNumber() {
		return number;
	}
	
	public static String getAgency() {
		return agency;
	}
	
	public static String getCpf() {
		return cpf;
	}
	
	
}
