package masterCardBSensor.req;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardB
 * Component: MasterCardBSensor
 * 
 * This interface is required by the 'MasterCardBSensor' component (MasterCardBSensor.req.IMasterCardManager). 
 * All signatures of business methods present here must be present in the 'IMasterCardManager' interface 
 * on the component origin (MasterCardB.prov.IMasterCardManager).
 */
public interface IMasterCardManager {
	public String pagarMaster(float valor ,String nomeCartao , String numeroCartao,String validadeCartao,String cifCartao,int parcelas);
	public boolean getDisponibilidade();

	//TODO: Signatures of business methods

	//This interface must be equivalent to the interface provided on 
	//the provider component (MasterCardB.prov.IMasterCardManager)

}