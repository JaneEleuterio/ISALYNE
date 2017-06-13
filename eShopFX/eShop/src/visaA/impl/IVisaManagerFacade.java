package visaA.impl;

import visaA.core.VisaAM;
import visaA.core.VisaAMFactory;
import visaA.prov.IManager;
import visaA.prov.IVisaManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaA
 * Component: VisaA
 */
class IVisaManagerFacade implements IInterfaceTags, IVisaManager {


    private IManager manager = null;
    private VisaAM visaAM;

    IVisaManagerFacade(IManager manager) {
        this.manager = manager;
        this.visaAM = VisaAMFactory.createInstance(this.manager);
    }

    //TODO: Each business method from the interface 'IVisaManager'
	//must be implemented here by invoking its method in the concrete 
	//component  VisaA and with 'synchronized' notation
	
	//example of a business method 
	/*
	public synchronized type businessMethod(param) {
        return  visaAM.businessMethod(param);
    }
	*/
    public synchronized String pagarVisa(float valor,String nomeCartao,String numeroCartao,String validadeCartao,String cifCartao,int parcelas){
    	return visaAM.pagarVisa(valor, nomeCartao, numeroCartao, validadeCartao, cifCartao,parcelas);
    }
    public synchronized boolean getDisponibilidade(){
    	return visaAM.getDisponibilidade();
    }
}