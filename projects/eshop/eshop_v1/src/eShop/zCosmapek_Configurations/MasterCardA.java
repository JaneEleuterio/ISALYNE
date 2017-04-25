package eShop.zCosmapek_Configurations;

import cosmapek.interfaces.IExecution;
import masterCardA.prov.IManager;
import masterCardA.prov.IMasterCardManager;

import masterCardA.impl.ComponentFactory;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardA
 * Component: MasterCardA
 *
 * Manages the MasterCardA configuration.
 */
public class MasterCardA implements IExecution,IInterfaceTags {
    private IManager masterCardA;
	 private IMasterCardManager IMasterCardManagerIComp;
	
	
	
	
    @Override public void execute() {
	/*      masterCardA = ComponentFactory.createInstance();
			IMasterCardManagerIComp =
                (IMasterCardManager) masterCardA.getProvidedInterface(IMasterCardManagerTag);
			
        
	*/
	}


}