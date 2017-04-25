package conn_BankInvoice_Payment.impl;

import conn_BankInvoice_Payment.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: BankInvoice
 * Component: Conn_BankInvoice_Payment
 */
class Adapter
    implements payment.req.IBankInvoiceManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

	//TODO: Adaptation of business methods
	//This class connects the business methods of the 
	//required interface 'payment.req.IBankInvoiceManager' 
	//with business methods from the provided interface
	//'bankInvoice.prov.IBankInvoiceManager'	
	
	//example of a business method
	/*
	@Override
    public synchronized type businessMethod(param){
        bankInvoice.prov.IBankInvoiceManager comp_bankInvoice =
                (bankInvoice.prov.IBankInvoiceManager) this.manager.getRequiredInterface(IBankInvoiceManagerTag);
        return comp_bankInvoice.businessMethod(param);
    }
	*/
	public synchronized String pagamentoBoleto(float valor){
		bankInvoice.prov.IBankInvoiceManager comp_bankInvoice =
                (bankInvoice.prov.IBankInvoiceManager) this.manager.getRequiredInterface(IBankInvoiceManagerTag);
        return comp_bankInvoice.pagamentoBoleto(valor);
	}
    
}