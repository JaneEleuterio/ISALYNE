package conn_BankTransfer_Payment.impl;

import conn_BankTransfer_Payment.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: BankTransfer
 * Component: Conn_BankTransfer_Payment
 */
class Adapter
    implements payment.req.IBankTransferManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

	//TODO: Adaptation of business methods
	//This class connects the business methods of the 
	//required interface 'payment.req.IBankTransferManager' 
	//with business methods from the provided interface
	//'bankTransfer.prov.IBankTransferManager'	
	
	//example of a business method
	/*
	@Override
    public synchronized type businessMethod(param){
        bankTransfer.prov.IBankTransferManager comp_bankTransfer =
                (bankTransfer.prov.IBankTransferManager) this.manager.getRequiredInterface(IBankTransferManagerTag);
        return comp_bankTransfer.businessMethod(param);
    }
	*/
	
    
}