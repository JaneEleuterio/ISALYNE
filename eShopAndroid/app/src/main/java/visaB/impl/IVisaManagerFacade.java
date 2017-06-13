package visaB.impl;

import visaB.core.VisaBM;
import visaB.core.VisaBMFactory;
import visaB.prov.IManager;
import visaB.prov.IVisaManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaB
 * Component: VisaB
 */
class IVisaManagerFacade implements IInterfaceTags, IVisaManager {


    private IManager manager = null;
    private VisaBM visaBM;

    IVisaManagerFacade(IManager manager) {
        this.manager = manager;
        this.visaBM = VisaBMFactory.createInstance(this.manager);
    }

    //TODO: Each business method from the interface 'IVisaManager'
	//must be implemented here by invoking its method in the concrete 
	//component  VisaB and with 'synchronized' notation
	
	//example of a business method 
	/*
	public synchronized type businessMethod(param) {
        return  visaBM.businessMethod(param);
    }
	*/
    public synchronized String pagarVisa(float valor,String nomeCartao,String numeroCartao,String validadeCartao,String cifCartao,int parcelas){
    	return visaBM.pagarVisa(valor, nomeCartao, numeroCartao, validadeCartao, cifCartao,parcelas);
    }
    public synchronized boolean getDisponibilidade(){
    	return visaBM.getDisponibilidade();
    }
}