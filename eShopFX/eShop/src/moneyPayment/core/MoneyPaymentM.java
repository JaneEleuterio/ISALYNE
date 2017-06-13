package moneyPayment.core;

import moneyPayment.prov.IManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MoneyPayment
 * Component: MoneyPayment
 *
 * This class contains the concrete methods of component 'MoneyPayment'.
 */
public class MoneyPaymentM {
    private IManager manager;

    
    public MoneyPaymentM(IManager manager) {
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
    public synchronized float calcularTroco(float valoraPagar , float valorRecebido){	
    	return valorRecebido - valoraPagar;
    }
    public synchronized boolean registrarCompra(){
    	System.out.print("Compra Registrada com sucesso!!");
    	return true;
    }
}