package masterCardASensor.req;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardA
 * Component: MasterCardASensor
 * 
 * This interface is required by the 'MasterCardASensor' component (MasterCardASensor.req.IMasterCardManager). 
 * All signatures of business methods present here must be present in the 'IMasterCardManager' interface 
 * on the component origin (MasterCardA.prov.IMasterCardManager).
 */
public interface IMasterCardManager {
	public String pagarMaster(float valor ,String nomeCartao , String numeroCartao,String validadeCartao,String cifCartao,int parcelas);
	public boolean getDisponibilidade();

	//TODO: Signatures of business methods

	//This interface must be equivalent to the interface provided on 
	//the provider component (MasterCardA.prov.IMasterCardManager)

}