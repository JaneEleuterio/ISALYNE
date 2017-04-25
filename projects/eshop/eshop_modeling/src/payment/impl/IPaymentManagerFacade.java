package payment.impl;

import payment.core.PaymentM;
import payment.core.PaymentMFactory;

import payment.prov.IManager;
import payment.prov.IPaymentManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: Payment
 * Component: Payment
 */
class IPaymentManagerFacade implements IInterfaceTags, IPaymentManager {


    private IManager manager = null;
    private PaymentM paymentM;

    IPaymentManagerFacade(IManager manager) {
        this.manager = manager;
        this.paymentM = PaymentMFactory.createInstance(this.manager);
    }

    //TODO: Each business method from the interface 'IPaymentManager'
	//must be implemented here by invoking its method in the concrete 
	//component  Payment and with 'synchronized' notation
	
	//example of a business method 
	/*
	public synchronized type businessMethod(param) {
        return  paymentM.businessMethod(param);
    }
	*/
}