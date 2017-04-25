package conn_VisaA_VisaASensor.impl;

import conn_VisaA_VisaASensor.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaA
 * Component: Conn_VisaA_VisaASensor
 */
class Adapter
    implements visaASensor.req.IVisaManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

	//TODO: Adaptation of business methods
	//This class connects the business methods of the 
	//required interface 'visaASensor.req.IVisaManager' 
	//with business methods from the provided interface
	//'visaA.prov.IVisaManager'	
	
	//example of a business method
	/*
	@Override
    public synchronized type businessMethod(param){
        visaA.prov.IVisaManager comp_visaA =
                (visaA.prov.IVisaManager) this.manager.getRequiredInterface(IVisaManagerTag);
        return comp_visaA.businessMethod(param);
    }
	*/
	
    
}