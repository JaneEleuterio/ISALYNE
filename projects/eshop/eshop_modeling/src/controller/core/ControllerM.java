package controller.core;

import controller.prov.IManager;

import controller.req.ICatalogueManager;
import controller.req.IPaymentManager;
import controller.req.IGUIManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: App
 * Component: Controller
 *
 * This class contains the concrete methods of component 'Controller'.
 */
public class ControllerM {
    private IManager manager;


		private ICatalogueManager i_ICatalogueManager;
		private IPaymentManager i_IPaymentManager;
		private IGUIManager i_IGUIManager;
    
    public ControllerM(IManager manager) {
        this.manager = manager;
    }

    private void getManagers() {
	

			this.i_ICatalogueManager =
	                (ICatalogueManager) manager.getRequiredInterface("ICatalogueManager");
			this.i_IPaymentManager =
	                (IPaymentManager) manager.getRequiredInterface("IPaymentManager");
			this.i_IGUIManager =
	                (IGUIManager) manager.getRequiredInterface("IGUIManager");
        
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