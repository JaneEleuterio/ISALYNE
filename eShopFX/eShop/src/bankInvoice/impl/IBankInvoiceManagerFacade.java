package bankInvoice.impl;

import bankInvoice.core.BankInvoiceM;
import bankInvoice.core.BankInvoiceMFactory;

import bankInvoice.prov.IManager;
import bankInvoice.prov.IBankInvoiceManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: BankInvoice
 * Component: BankInvoice
 */
class IBankInvoiceManagerFacade implements IInterfaceTags, IBankInvoiceManager {


    private IManager manager = null;
    private BankInvoiceM bankInvoiceM;

    IBankInvoiceManagerFacade(IManager manager) {
        this.manager = manager;
        this.bankInvoiceM = BankInvoiceMFactory.createInstance(this.manager);
    }

    //TODO: Each business method from the interface 'IBankInvoiceManager'
	//must be implemented here by invoking its method in the concrete 
	//component  BankInvoice and with 'synchronized' notation
	
	//example of a business method 
	/*
	
	public synchronized type businessMethod(param) {
        return  bankInvoiceM.businessMethod(param);
    }
	*/
    public synchronized String pagamentoBoleto(float valor){
    	return bankInvoiceM.pagamentoBoleto(valor);
    }
}