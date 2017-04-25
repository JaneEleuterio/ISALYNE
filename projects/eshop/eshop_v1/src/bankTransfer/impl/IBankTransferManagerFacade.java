package bankTransfer.impl;

import bankTransfer.core.BankTransferM;
import bankTransfer.core.BankTransferMFactory;

import bankTransfer.prov.IManager;
import bankTransfer.prov.IBankTransferManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: BankTransfer
 * Component: BankTransfer
 */
class IBankTransferManagerFacade implements IInterfaceTags, IBankTransferManager {


    private IManager manager = null;
    private BankTransferM bankTransferM;

    IBankTransferManagerFacade(IManager manager) {
        this.manager = manager;
        this.bankTransferM = BankTransferMFactory.createInstance(this.manager);
    }

    //TODO: Each business method from the interface 'IBankTransferManager'
	//must be implemented here by invoking its method in the concrete 
	//component  BankTransfer and with 'synchronized' notation
	
	//example of a business method 
	/*
	public synchronized type businessMethod(param) {
        return  bankTransferM.businessMethod(param);
    }
	*/
    
    public synchronized String pagamentoTransferencia(float valor){
    	return bankTransferM.pagamentoTransferencia(valor);
    }
}