package conn_VisaA_CreditCard.impl;

import conn_VisaA_CreditCard.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaA
 * Component: Conn_VisaA_CreditCard
 */
class Adapter
    implements creditCard.req.IVisaManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

	//TODO: Adaptation of business methods
	//This class connects the business methods of the 
	//required interface 'creditCard.req.IVisaManager' 
	//with business methods from the provided interface
	//'visaA.prov.IVisaManager'	
	
	//example of a business method
	/*
	@Override
    public synchronized type businessMethod(param){
        
    }
	*/
    public synchronized  String pagarVisa(float valor,String nomeCartao,String numeroCartao,String validadeCartao,String cifCartao,int parcelas){
    	visaA.prov.IVisaManager comp_visaA =
                (visaA.prov.IVisaManager) this.manager.getRequiredInterface(IVisaManagerTag);
        return comp_visaA.pagarVisa(valor, nomeCartao, numeroCartao, validadeCartao, cifCartao,parcelas);
    }
    public synchronized boolean getDisponibilidade(){
    	visaA.prov.IVisaManager comp_visaA =
                (visaA.prov.IVisaManager) this.manager.getRequiredInterface(IVisaManagerTag);
        return comp_visaA.getDisponibilidade();
    	
    }
    
}