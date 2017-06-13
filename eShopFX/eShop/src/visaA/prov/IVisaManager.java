package visaA.prov;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaA
 * Component: VisaA
 * 
 * This 'IVisaManager' interface is provided by the component 'VisaA'. All 
 * signatures to business methods present here should be updated on the components that 
 * have this 'IVisaManager' interface as required.
 */
public interface IVisaManager {
	
	public String pagarVisa(float valor,String nomeCartao,String numeroCartao,String validadeCartao,String cifCartao,int parcelas);
	public boolean getDisponibilidade();
    //TODO: Signatures of business methods

	//This interface must be equivalent to the 
	//required interfaces in client components
}