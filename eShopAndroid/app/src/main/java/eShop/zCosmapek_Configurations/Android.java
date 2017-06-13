package eShop.zCosmapek_Configurations;

import cosmapek.interfaces.IExecution;
import android.prov.IManager;
import android.prov.IGUIManager;


/**
* Created by COSMAPE-Feature IDE on 2016-jul-11.
* Feature: Android
* Component: Android
*
* Manages the Java configuration.
*/

public class Android implements IExecution,IInterfaceTags {
    private IManager android;
    private IGUIManager IGUIManagerIComp;

    @Override public void execute() {
	/*      android = ComponentFactory.createInstance();
			IGUIManagerIComp =
                (IGUIManager) android.getProvidedInterface(IGUIManagerTag);


	*/
    }
}
