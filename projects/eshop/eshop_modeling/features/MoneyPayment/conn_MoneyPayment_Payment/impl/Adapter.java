package conn_MoneyPayment_Payment.impl;

import conn_MoneyPayment_Payment.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MoneyPayment
 * Component: Conn_MoneyPayment_Payment
 */
class Adapter
    implements payment.req.IMoneyPaymentManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

	//TODO: Adaptation of business methods
	//This class connects the business methods of the 
	//required interface 'payment.req.IMoneyPaymentManager' 
	//with business methods from the provided interface
	//'moneyPayment.prov.IMoneyPaymentManager'	
	
	//example of a business method
	/*
	@Override
    public synchronized type businessMethod(param){
        moneyPayment.prov.IMoneyPaymentManager comp_moneyPayment =
                (moneyPayment.prov.IMoneyPaymentManager) this.manager.getRequiredInterface(IMoneyPaymentManagerTag);
        return comp_moneyPayment.businessMethod(param);
    }
	*/
	
    
}