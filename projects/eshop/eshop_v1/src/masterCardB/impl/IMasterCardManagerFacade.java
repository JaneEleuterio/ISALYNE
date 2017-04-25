package masterCardB.impl;

import masterCardB.core.MasterCardBM;
import masterCardB.core.MasterCardBMFactory;
import masterCardB.prov.IManager;
import masterCardB.prov.IMasterCardManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardB
 * Component: MasterCardB
 */
class IMasterCardManagerFacade implements IInterfaceTags, IMasterCardManager {


    private IManager manager = null;
    private MasterCardBM masterCardBM;

    IMasterCardManagerFacade(IManager manager) {
        this.manager = manager;
        this.masterCardBM = MasterCardBMFactory.createInstance(this.manager);
    }

    //TODO: Each business method from the interface 'IMasterCardManager'
	//must be implemented here by invoking its method in the concrete 
	//component  MasterCardB and with 'synchronized' notation
	
	//example of a business method 
	/*
	public synchronized type businessMethod(param) {
        return  masterCardBM.businessMethod(param);
    }
	*/
    public synchronized String pagarMaster(float valor ,String nomeCartao , String numeroCartao,String validadeCartao,String cifCartao,int parcelas){
    	return masterCardBM.pagarMaster(valor, nomeCartao, numeroCartao, validadeCartao, cifCartao,parcelas);
    }
    public synchronized boolean getDisponibilidade(){
    	return masterCardBM.getDisponibilidade();
    }
}