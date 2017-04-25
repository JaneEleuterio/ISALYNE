package controller.impl;

import controller.core.ControllerM;
import controller.core.ControllerMFactory;

import controller.prov.IManager;
import controller.prov.IControllerManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: App
 * Component: Controller
 */
class IControllerManagerFacade implements IInterfaceTags, IControllerManager {


    private IManager manager = null;
    private ControllerM controllerM;

    IControllerManagerFacade(IManager manager) {
        this.manager = manager;
        this.controllerM = ControllerMFactory.createInstance(this.manager);
    }

    //TODO: Each business method from the interface 'IControllerManager'
	//must be implemented here by invoking its method in the concrete 
	//component  Controller and with 'synchronized' notation
	
	//example of a business method 
	/*
	public synchronized type businessMethod(param) {
        return  controllerM.businessMethod(param);
    }
	*/
}