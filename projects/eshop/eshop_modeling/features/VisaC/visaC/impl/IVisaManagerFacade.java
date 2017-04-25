package visaC.impl;

import visaC.core.VisaCM;
import visaC.core.VisaCMFactory;

import visaC.prov.IManager;
import visaC.prov.IVisaManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaC
 * Component: VisaC
 */
class IVisaManagerFacade implements IInterfaceTags, IVisaManager {


    private IManager manager = null;
    private VisaCM visaCM;

    IVisaManagerFacade(IManager manager) {
        this.manager = manager;
        this.visaCM = VisaCMFactory.createInstance(this.manager);
    }

    //TODO: Each business method from the interface 'IVisaManager'
	//must be implemented here by invoking its method in the concrete 
	//component  VisaC and with 'synchronized' notation
	
	//example of a business method 
	/*
	public synchronized type businessMethod(param) {
        return  visaCM.businessMethod(param);
    }
	*/
}