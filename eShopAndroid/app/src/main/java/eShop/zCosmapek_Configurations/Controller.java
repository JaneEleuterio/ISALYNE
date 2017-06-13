package eShop.zCosmapek_Configurations;

import cosmapek.interfaces.IExecution;
import controller.prov.IManager;
import controller.prov.IControllerManager;

import controller.impl.ComponentFactory;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: App
 * Component: Controller
 *
 * Manages the Controller configuration.
 */
public class Controller implements IExecution,IInterfaceTags {
    private IManager controller;
	 private IControllerManager IControllerManagerIComp;
	
	
	
	
    @Override public void execute() {
	/*      controller = ComponentFactory.createInstance();
			IControllerManagerIComp =
                (IControllerManager) controller.getProvidedInterface(IControllerManagerTag);
			
        
	*/
	}


}