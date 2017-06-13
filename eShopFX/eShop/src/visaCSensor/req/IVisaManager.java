package visaCSensor.req;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaC
 * Component: VisaCSensor
 * 
 * This interface is required by the 'VisaCSensor' component (VisaCSensor.req.IVisaManager). 
 * All signatures of business methods present here must be present in the 'IVisaManager' interface 
 * on the component origin (VisaC.prov.IVisaManager).
 */
public interface IVisaManager {
	public String pagarVisa(float valor,String nomeCartao,String numeroCartao,String validadeCartao,String cifCartao,int parcelas);
	//TODO: Signatures of business methods
	public boolean getDisponibilidade();

	//This interface must be equivalent to the interface provided on 
	//the provider component (VisaC.prov.IVisaManager)

}