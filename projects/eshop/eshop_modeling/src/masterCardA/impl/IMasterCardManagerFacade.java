package masterCardA.impl;

import masterCardA.core.MasterCardAM;
import masterCardA.core.MasterCardAMFactory;

import masterCardA.prov.IManager;
import masterCardA.prov.IMasterCardManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardA
 * Component: MasterCardA
 */
class IMasterCardManagerFacade implements IInterfaceTags, IMasterCardManager {


    private IManager manager = null;
    private MasterCardAM masterCardAM;

    IMasterCardManagerFacade(IManager manager) {
        this.manager = manager;
        this.masterCardAM = MasterCardAMFactory.createInstance(this.manager);
    }

    //TODO: Each business method from the interface 'IMasterCardManager'
	//must be implemented here by invoking its method in the concrete 
	//component  MasterCardA and with 'synchronized' notation
	
	//example of a business method 
	/*
	public synchronized type businessMethod(param) {
        return  masterCardAM.businessMethod(param);
    }
	*/
}