package creditCard.impl;

import creditCard.core.CreditCardM;
import creditCard.core.CreditCardMFactory;
import creditCard.prov.IManager;
import creditCard.prov.ICreditCardManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: CreditCard
 * Component: CreditCard
 */
class ICreditCardManagerFacade implements IInterfaceTags, ICreditCardManager {


    private IManager manager = null;
    private CreditCardM creditCardM;

    ICreditCardManagerFacade(IManager manager) {
        this.manager = manager;
        this.creditCardM = CreditCardMFactory.createInstance(this.manager);
    }

    //TODO: Each business method from the interface 'ICreditCardManager'
	//must be implemented here by invoking its method in the concrete 
	//component  CreditCard and with 'synchronized' notation
	
	//example of a business method 
	/*
	public synchronized type businessMethod(param) {
        return  creditCardM.businessMethod(param);
    }
	*/
    public synchronized boolean getDisponibilidadeVISA(){
    	return creditCardM.getDisponibilidadeVISA();
    	
    }
    public synchronized boolean getDisponibilidadeMASTER(){
    	return creditCardM.getDIsponibilidadeMASTER();
    }
    public synchronized String pagarMasterCredit(float valor ,String nomeCartao , String numeroCartao,String validadeCartao,String cifCartao,int parcelas){
    	return creditCardM.pagarMasterCredit(valor, nomeCartao, numeroCartao, validadeCartao, cifCartao,parcelas);
    }
    public synchronized String pagarVisaCredit(float valor,String nomeCartao,String numeroCartao,String validadeCartao,String cifCartao,int parcelas){
    	return creditCardM.pagarVisaCredit(valor, nomeCartao, numeroCartao, validadeCartao, cifCartao,parcelas);
    }
}