package eShop.zCosmapek_Configurations;

import cosmapek.interfaces.IExecution;
import bankInvoice.prov.IManager;
import bankInvoice.prov.IBankInvoiceManager;

import bankInvoice.impl.ComponentFactory;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: BankInvoice
 * Component: BankInvoice
 *
 * Manages the BankInvoice configuration.
 */
public class BankInvoice implements IExecution,IInterfaceTags {
    private IManager bankInvoice;
	 private IBankInvoiceManager IBankInvoiceManagerIComp;
	
	
	
	
    @Override public void execute() {
	/*      bankInvoice = ComponentFactory.createInstance();
			IBankInvoiceManagerIComp =
                (IBankInvoiceManager) bankInvoice.getProvidedInterface(IBankInvoiceManagerTag);
			
        
	*/
	}


}