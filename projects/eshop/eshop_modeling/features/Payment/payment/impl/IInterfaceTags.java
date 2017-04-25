package payment.impl;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: Payment
 * Component: Payment
 */
interface IInterfaceTags {
    //provided
    static final String IManagerProv = "IManager";	
	static final String IPaymentManagerProv = "IPaymentManager";	 
	
    //required  
	static final String ICreditCardManagerReq = "ICreditCardManager";
	static final String IBankTransferManagerReq = "IBankTransferManager";
	static final String IBankInvoiceManagerReq = "IBankInvoiceManager";
	static final String IMoneyPaymentManagerReq = "IMoneyPaymentManager";
    
}