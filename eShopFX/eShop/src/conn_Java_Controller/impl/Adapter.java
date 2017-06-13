package conn_Java_Controller.impl;

import conn_Java_Controller.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: Java
 * Component: Conn_Java_Controller
 */
class Adapter
    implements controller.req.IGUIManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

	//TODO: Adaptation of business methods
	//This class connects the business methods of the 
	//required interface 'controller.req.IGUIManager' 
	//with business methods from the provided interface
	//'java.prov.IGUIManager'	
	
	//example of a business method
	/*
	@Override
    public synchronized type businessMethod(param){
        java.prov.IGUIManager comp_java =
                (java.prov.IGUIManager) this.manager.getRequiredInterface(IGUIManagerTag);
        return comp_java.businessMethod(param);
    }
	*/
	
    
}