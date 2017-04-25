package moneyPayment.impl;

import moneyPayment.core.MoneyPaymentM;
import moneyPayment.core.MoneyPaymentMFactory;

import moneyPayment.prov.IManager;
import moneyPayment.prov.IMoneyPaymentManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MoneyPayment
 * Component: MoneyPayment
 */
class IMoneyPaymentManagerFacade implements IInterfaceTags, IMoneyPaymentManager {


    private IManager manager = null;
    private MoneyPaymentM moneyPaymentM;

    IMoneyPaymentManagerFacade(IManager manager) {
        this.manager = manager;
        this.moneyPaymentM = MoneyPaymentMFactory.createInstance(this.manager);
    }

    //TODO: Each business method from the interface 'IMoneyPaymentManager'
	//must be implemented here by invoking its method in the concrete 
	//component  MoneyPayment and with 'synchronized' notation
	
	//example of a business method 
	/*
	public synchronized type businessMethod(param) {
        return  moneyPaymentM.businessMethod(param);
    }
	*/
    
    public synchronized float calcularTroco(float valoraPagar , float valorRecebido){
    	return moneyPaymentM.calcularTroco(valoraPagar , valorRecebido);
    }
    public synchronized boolean registrarCompra(){
    	return moneyPaymentM.registrarCompra();
    }
}