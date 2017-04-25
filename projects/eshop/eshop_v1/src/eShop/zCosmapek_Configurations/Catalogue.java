package eShop.zCosmapek_Configurations;

import cosmapek.interfaces.IExecution;
import catalogue.prov.IManager;
import catalogue.prov.ICatalogueManager;

import catalogue.impl.ComponentFactory;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: Catalogue
 * Component: Catalogue
 *
 * Manages the Catalogue configuration.
 */
public class Catalogue implements IExecution,IInterfaceTags {
    private IManager catalogue;
	 private ICatalogueManager ICatalogueManagerIComp;
	
	
	
	
    @Override public void execute() {
	/*      catalogue = ComponentFactory.createInstance();
			ICatalogueManagerIComp =
                (ICatalogueManager) catalogue.getProvidedInterface(ICatalogueManagerTag);
			
        
	*/
	}


}