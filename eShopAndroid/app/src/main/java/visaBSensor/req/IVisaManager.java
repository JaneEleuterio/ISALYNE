package visaBSensor.req;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaB
 * Component: VisaBSensor
 * 
 * This interface is required by the 'VisaBSensor' component (VisaBSensor.req.IVisaManager). 
 * All signatures of business methods present here must be present in the 'IVisaManager' interface 
 * on the component origin (VisaB.prov.IVisaManager).
 */
public interface IVisaManager {
	public String pagarVisa(float valor,String nomeCartao,String numeroCartao,String validadeCartao,String cifCartao,int parcelas);
	public boolean getDisponibilidade();
	//TODO: Signatures of business methods

	//This interface must be equivalent to the interface provided on 
	//the provider component (VisaB.prov.IVisaManager)

}