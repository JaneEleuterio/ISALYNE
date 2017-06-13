package eShop.zCosmapek_Configurations;

import cosmapek.interfaces.IExecution;
import creditCard.prov.IManager;
import creditCard.prov.ICreditCardManager;

import creditCard.impl.ComponentFactory;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: CreditCard
 * Component: CreditCard
 *
 * Manages the CreditCard configuration.
 */
public class CreditCard implements IExecution,IInterfaceTags {
    private IManager creditCard;
	 private ICreditCardManager ICreditCardManagerIComp;
	
	
	
	
    @Override public void execute() {
	/*      creditCard = ComponentFactory.createInstance();
			ICreditCardManagerIComp =
                (ICreditCardManager) creditCard.getProvidedInterface(ICreditCardManagerTag);
			
        
	*/
	}


}