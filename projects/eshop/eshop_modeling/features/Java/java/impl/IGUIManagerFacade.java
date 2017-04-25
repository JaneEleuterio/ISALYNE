package java.impl;

import java.core.JavaM;
import java.core.JavaMFactory;

import java.prov.IManager;
import java.prov.IGUIManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: Java
 * Component: Java
 */
class IGUIManagerFacade implements IInterfaceTags, IGUIManager {


    private IManager manager = null;
    private JavaM javaM;

    IGUIManagerFacade(IManager manager) {
        this.manager = manager;
        this.javaM = JavaMFactory.createInstance(this.manager);
    }

    //TODO: Each business method from the interface 'IGUIManager'
	//must be implemented here by invoking its method in the concrete 
	//component  Java and with 'synchronized' notation
	
	//example of a business method 
	/*
	public synchronized type businessMethod(param) {
        return  javaM.businessMethod(param);
    }
	*/
}