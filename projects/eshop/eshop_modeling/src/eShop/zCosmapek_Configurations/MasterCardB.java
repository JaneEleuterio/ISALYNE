package eShop.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;
import masterCardB.prov.IManager;
import masterCardB.prov.IMasterCardManager;

import masterCardB.impl.ComponentFactory;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardB
 * Component: MasterCardB
 *
 * Manages the MasterCardB configuration.
 */
public class MasterCardB implements IExecution,IInterfaceTags {
    private IManager masterCardB;
	 private IMasterCardManager IMasterCardManagerIComp;
	
	
	
	
    @Override public void execute() {
	/*      masterCardB = ComponentFactory.createInstance();
			IMasterCardManagerIComp =
                (IMasterCardManager) masterCardB.getProvidedInterface(IMasterCardManagerTag);
			
        
	*/
	}


}