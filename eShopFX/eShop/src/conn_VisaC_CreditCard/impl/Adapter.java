package conn_VisaC_CreditCard.impl;

import conn_VisaC_CreditCard.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaC
 * Component: Conn_VisaC_CreditCard
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
	//'visaC.prov.IVisaManager'	
	
	//example of a business method
	/*
	@Override
    public synchronized type businessMethod(param){
        visaC.prov.IVisaManager comp_visaC =
                (visaC.prov.IVisaManager) this.manager.getRequiredInterface(IVisaManagerTag);
        return comp_visaC.businessMethod(param);
    }
	*/
    public synchronized String pagarVisa(float valor , String nomeCartao , String numeroCartao , String validadeCartao , String cifCartao,int parcelas){
        visaC.prov.IVisaManager comp_visaC =
                (visaC.prov.IVisaManager) this.manager.getRequiredInterface(IVisaManagerTag);
        return comp_visaC.pagarVisa(valor, nomeCartao, numeroCartao, validadeCartao, cifCartao,parcelas);
    }
	
    public synchronized boolean getDisponibilidade(){
    	visaC.prov.IVisaManager comp_visaC =
                (visaC.prov.IVisaManager) this.manager.getRequiredInterface(IVisaManagerTag);
       return comp_visaC.getDisponibilidade();
    }
}