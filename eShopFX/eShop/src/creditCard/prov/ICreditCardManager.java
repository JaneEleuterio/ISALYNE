package creditCard.prov;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: CreditCard
 * Component: CreditCard
 * 
 * This 'ICreditCardManager' interface is provided by the component 'CreditCard'. All 
 * signatures to business methods present here should be updated on the components that 
 * have this 'ICreditCardManager' interface as required.
 */
public interface ICreditCardManager {
	public String pagarMasterCredit(float valor ,String nomeCartao , String numeroCartao,String validadeCartao,String cifCartao,int parcelas);
	public String pagarVisaCredit(float valor,String nomeCartao,String numeroCartao,String validadeCartao,String cifCartao,int parcelas);
	public boolean getDisponibilidadeVISA();
	public boolean getDisponibilidadeMASTER();
	//TODO: Signatures of business methods

	//This interface must be equivalent to the 
	//required interfaces in client components
}