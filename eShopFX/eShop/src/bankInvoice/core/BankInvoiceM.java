package bankInvoice.core;

import bankInvoice.prov.IManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: BankInvoice
 * Component: BankInvoice
 *
 * This class contains the concrete methods of component 'BankInvoice'.
 */
public class BankInvoiceM {
    private IManager manager;

    
    public BankInvoiceM(IManager manager) {
        this.manager = manager;
    }

    private void getManagers() {
	
        
    }

	//TODO: Logic component methods
	//All business methods must follow the structure below, 
	//with synchronized and calling the method getManagers()
	
	//example of a business method
	/*
	public synchronized type businessMethod(param) {
	     getManagers();
			...
        return something;
    }
	*/
    public synchronized String pagamentoBoleto(float valor){
    	getManagers();
    	String boleto;
    	
    	boleto = "Valor a ser pago no:" + valor + "\n\n\n Vencimento 10/10/16";
    	
    	
    	return boleto;
    }
}