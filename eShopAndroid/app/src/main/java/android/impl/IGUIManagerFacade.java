package android.impl;

import android.core.AndroidM;
import android.core.AndroidMFactory;
import android.impl.*;
import android.prov.IGUIManager;
import android.prov.IManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: Android
 * Component: Android
 */
class IGUIManagerFacade implements android.impl.IInterfaceTags, IGUIManager {


    private IManager manager = null;
    private AndroidM androidM;

    IGUIManagerFacade(IManager manager) {
        this.manager = manager;
        this.androidM = AndroidMFactory.createInstance(this.manager);
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