package eShop.zCosmapek_Configurations;

import cosmapek.interfaces.IExecution;
import bankTransfer.prov.IManager;
import bankTransfer.prov.IBankTransferManager;

import bankTransfer.impl.ComponentFactory;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: BankTransfer
 * Component: BankTransfer
 *
 * Manages the BankTransfer configuration.
 */
public class BankTransfer implements IExecution,IInterfaceTags {
    private IManager bankTransfer;
	 private IBankTransferManager IBankTransferManagerIComp;
	
	
	
	
    @Override public void execute() {
	/*      bankTransfer = ComponentFactory.createInstance();
			IBankTransferManagerIComp =
                (IBankTransferManager) bankTransfer.getProvidedInterface(IBankTransferManagerTag);
			
        
	*/
	}


}