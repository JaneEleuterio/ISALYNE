package eShop.zCosmapek_Configurations;

import cosmapek.interfaces.IExecution;
import moneyPayment.prov.IManager;
import moneyPayment.prov.IMoneyPaymentManager;

import moneyPayment.impl.ComponentFactory;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MoneyPayment
 * Component: MoneyPayment
 *
 * Manages the MoneyPayment configuration.
 */
public class MoneyPayment implements IExecution,IInterfaceTags {
    private IManager moneyPayment;
	 private IMoneyPaymentManager IMoneyPaymentManagerIComp;
	
	
	
	
    @Override public void execute() {
	/*      moneyPayment = ComponentFactory.createInstance();
			IMoneyPaymentManagerIComp =
                (IMoneyPaymentManager) moneyPayment.getProvidedInterface(IMoneyPaymentManagerTag);
			
        
	*/
	}


}