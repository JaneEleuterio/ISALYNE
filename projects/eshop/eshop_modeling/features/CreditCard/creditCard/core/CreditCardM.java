package creditCard.core;

import creditCard.prov.IManager;

import creditCard.req.IMasterCardManager;
import creditCard.req.IVisaManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: CreditCard
 * Component: CreditCard
 *
 * This class contains the concrete methods of component 'CreditCard'.
 */
public class CreditCardM {
    private IManager manager;


		private IMasterCardManager i_IMasterCardManager;
		private IVisaManager i_IVisaManager;
    
    public CreditCardM(IManager manager) {
        this.manager = manager;
    }

    private void getManagers() {
	

			this.i_IMasterCardManager =
	                (IMasterCardManager) manager.getRequiredInterface("IMasterCardManager");
			this.i_IVisaManager =
	                (IVisaManager) manager.getRequiredInterface("IVisaManager");
        
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
}