package payment.req;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: Payment
 * Component: Payment
 * 
 * This interface is required by the 'Payment' component (Payment.req.ICreditCardManager). 
 * All signatures of business methods present here must be present in the 'ICreditCardManager' interface 
 * on the component origin (CreditCard.prov.ICreditCardManager).
 */
public interface ICreditCardManager {
	public String pagarMasterCredit(float valor ,String nomeCartao , String numeroCartao,String validadeCartao,String cifCartao,int parcelas);
	public String pagarVisaCredit(float valor,String nomeCartao,String numeroCartao,String validadeCartao,String cifCartao,int parcelas);
	public boolean getDisponibilidadeVISA();
	public boolean getDisponibilidadeMASTER();

	//TODO: Signatures of business methods

	//This interface must be equivalent to the interface provided on 
	//the provider component (CreditCard.prov.ICreditCardManager)

}