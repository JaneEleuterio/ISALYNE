package conn_VisaB_CreditCard.impl;

import conn_VisaB_CreditCard.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaB
 * Component: Conn_VisaB_CreditCard
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
	//'visaB.prov.IVisaManager'	
	
	//example of a business method
	/*
	@Override
    public synchronized type businessMethod(param){
        visaB.prov.IVisaManager comp_visaB =
                (visaB.prov.IVisaManager) this.manager.getRequiredInterface(IVisaManagerTag);
        return comp_visaB.businessMethod(param);
    }
	*/
    public synchronized String pagarVisa(float valor , String nomeCartao , String numeroCartao , String validadeCartao , String cifCartao,int parcelas){
        visaB.prov.IVisaManager comp_visaB =
                (visaB.prov.IVisaManager) this.manager.getRequiredInterface(IVisaManagerTag);
        return comp_visaB.pagarVisa(valor, nomeCartao, numeroCartao, validadeCartao, cifCartao,parcelas);
    }
	public synchronized boolean getDisponibilidade(){
		visaB.prov.IVisaManager comp_visaB =
                (visaB.prov.IVisaManager) this.manager.getRequiredInterface(IVisaManagerTag);
       return comp_visaB.getDisponibilidade();
	}
    
}