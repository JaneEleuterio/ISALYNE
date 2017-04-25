package eShop.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;
import payment.prov.IManager;
import payment.prov.IPaymentManager;

import payment.impl.ComponentFactory;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: Payment
 * Component: Payment
 *
 * Manages the Payment configuration.
 */
public class Payment implements IExecution,IInterfaceTags {
    private IManager payment;
	 private IPaymentManager IPaymentManagerIComp;
	
	
	
	
    @Override public void execute() {
	/*      payment = ComponentFactory.createInstance();
			IPaymentManagerIComp =
                (IPaymentManager) payment.getProvidedInterface(IPaymentManagerTag);
			
        
	*/
	}


}