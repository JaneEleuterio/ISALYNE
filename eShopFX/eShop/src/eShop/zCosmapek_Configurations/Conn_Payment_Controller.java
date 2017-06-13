package eShop.zCosmapek_Configurations;

import cosmapek.interfaces.IExecution;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: Payment
 * Component: Conn_Payment_Controller
 *
 * Manages the Conn_Payment_Controller configuration.
 */
public class Conn_Payment_Controller implements IExecution,IInterfaceTags {
    private payment.prov.IManager i_payment;
    private payment.prov.IPaymentManager i_IPaymentManager;

    private conn_Payment_Controller.prov.IManager i_conn_Payment_Controller;
    private controller.prov.IManager i_controller;

    @Override
    public synchronized void execute() {
        i_payment = payment.impl.ComponentFactory.createInstance();
        i_IPaymentManager =
                (payment.prov.IPaymentManager) i_payment.getProvidedInterface(IPaymentManagerTag);

        i_conn_Payment_Controller= conn_Payment_Controller.impl.ComponentFactory.createInstance();
        i_conn_Payment_Controller.setRequiredInterface(IPaymentManagerTag, i_IPaymentManager);

        i_controller = controller.impl.ComponentFactory.createInstance();
        i_controller.setRequiredInterface(IPaymentManagerTag,
                i_conn_Payment_Controller.getProvidedInterface(IPaymentManagerTag));
    }
}