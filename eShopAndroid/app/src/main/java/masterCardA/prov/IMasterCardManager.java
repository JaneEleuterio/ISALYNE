package masterCardA.prov;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardA
 * Component: MasterCardA
 * 
 * This 'IMasterCardManager' interface is provided by the component 'MasterCardA'. All 
 * signatures to business methods present here should be updated on the components that 
 * have this 'IMasterCardManager' interface as required.
 */
public interface IMasterCardManager {
	public String pagarMaster(float valor ,String nomeCartao , String numeroCartao,String validadeCartao,String cifCartao,int parcelas);
	public boolean getDisponibilidade();
    //TODO: Signatures of business methods

	//This interface must be equivalent to the 
	//required interfaces in client components
}