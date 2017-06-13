package conn_CreditCard_Payment.impl;

import conn_CreditCard_Payment.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: CreditCard
 * Component: Conn_CreditCard_Payment
 */
class Adapter
    implements payment.req.ICreditCardManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

	//TODO: Adaptation of business methods
	//This class connects the business methods of the 
	//required interface 'payment.req.ICreditCardManager' 
	//with business methods from the provided interface
	//'creditCard.prov.ICreditCardManager'	
	
	//example of a business method
	/*
	@Override
    public synchronized type businessMethod(param){
        creditCard.prov.ICreditCardManager comp_creditCard =
                (creditCard.prov.ICreditCardManager) this.manager.getRequiredInterface(ICreditCardManagerTag);
        return comp_creditCard.businessMethod(param);
    }
	*/
    public synchronized String pagarMasterCredit(float valor ,String nomeCartao , String numeroCartao,String validadeCartao,String cifCartao,int parcelas){
    	creditCard.prov.ICreditCardManager comp_creditCard =
                (creditCard.prov.ICreditCardManager) this.manager.getRequiredInterface(ICreditCardManagerTag);
        return comp_creditCard.pagarMasterCredit(valor, nomeCartao, numeroCartao, validadeCartao, cifCartao,parcelas);
    }
    
    public synchronized String pagarVisaCredit(float valor,String nomeCartao,String numeroCartao,String validadeCartao,String cifCartao,int parcelas){
    	creditCard.prov.ICreditCardManager comp_creditCard =
                (creditCard.prov.ICreditCardManager) this.manager.getRequiredInterface(ICreditCardManagerTag);
        return comp_creditCard.pagarVisaCredit(valor, nomeCartao, numeroCartao, validadeCartao, cifCartao,parcelas);
    }
    public synchronized boolean getDisponibilidadeVISA(){
    	creditCard.prov.ICreditCardManager comp_creditCard =
                (creditCard.prov.ICreditCardManager) this.manager.getRequiredInterface(ICreditCardManagerTag);
        return comp_creditCard.getDisponibilidadeVISA();
    	
    }
    public synchronized boolean getDisponibilidadeMASTER(){
    	creditCard.prov.ICreditCardManager comp_creditCard =
                (creditCard.prov.ICreditCardManager) this.manager.getRequiredInterface(ICreditCardManagerTag);
      return comp_creditCard.getDisponibilidadeMASTER();
    }
    
}