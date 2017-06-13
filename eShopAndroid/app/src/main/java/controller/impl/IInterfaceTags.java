package controller.impl;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: App
 * Component: Controller
 */
interface IInterfaceTags {
    //provided
    static final String IManagerProv = "IManager";	
	static final String IControllerManagerProv = "IControllerManager";	 
	
    //required  
	static final String ICatalogueManagerReq = "ICatalogueManager";
	static final String IPaymentManagerReq = "IPaymentManager";
	static final String IGUIManagerReq = "IGUIManager";
    
}