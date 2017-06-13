package conn_MasterCardB_CreditCard.impl;

import conn_MasterCardB_CreditCard.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardB
 * Component: Conn_MasterCardB_CreditCard
 */
class Adapter
    implements creditCard.req.IMasterCardManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

	//TODO: Adaptation of business methods
	//This class connects the business methods of the 
	//required interface 'creditCard.req.IMasterCardManager' 
	//with business methods from the provided interface
	//'masterCardB.prov.IMasterCardManager'	
	
	//example of a business method
	/*
	@Override
    public synchronized type businessMethod(param){
        masterCardB.prov.IMasterCardManager comp_masterCardB =
                (masterCardB.prov.IMasterCardManager) this.manager.getRequiredInterface(IMasterCardManagerTag);
        return comp_masterCardB.pagarMaster(valor, nomeCartao, numeroCartao, validadeCartao, cifCartao);
    }
	*/
    public synchronized String pagarMaster(float valor ,String nomeCartao , String numeroCartao,String validadeCartao,String cifCartao,int parcelas){
    	 masterCardB.prov.IMasterCardManager comp_masterCardB =
                (masterCardB.prov.IMasterCardManager) this.manager.getRequiredInterface(IMasterCardManagerTag);
        return comp_masterCardB.pagarMaster(valor, nomeCartao, numeroCartao, validadeCartao, cifCartao,parcelas);
    }
	public synchronized boolean getDisponibilidade(){
		masterCardA.prov.IMasterCardManager comp_masterCardB =
                (masterCardA.prov.IMasterCardManager) this.manager.getRequiredInterface(IMasterCardManagerTag);
        return comp_masterCardB.getDisponibilidade();
	}
    
}