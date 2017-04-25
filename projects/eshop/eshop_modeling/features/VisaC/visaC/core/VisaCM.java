package visaC.core;

import visaC.prov.IManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaC
 * Component: VisaC
 *
 * This class contains the concrete methods of component 'VisaC'.
 */
public class VisaCM {
    private IManager manager;

    
    public VisaCM(IManager manager) {
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
}