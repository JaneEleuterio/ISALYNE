package bankTransfer.core;

import bankTransfer.prov.IManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: BankTransfer
 * Component: BankTransfer
 *
 * This class contains the concrete methods of component 'BankTransfer'.
 */
public class BankTransferM {
    private IManager manager;

    
    public BankTransferM(IManager manager) {
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
    public synchronized String pagamentoTransferencia(float valor){
    	getManagers();
    	String transferencia = null;
    	
    	transferencia = "Banco\t Banco Ficticio\n"+ 
    	"Nome do Titular\t José Augusto\n" + 
    	"Conta Corrente\t 142567-50"+
    	"Agencia\t 4356"+
    	"CPF/CNPJ\t 648.489.389-50";
    
    
    	return transferencia;
    }
}