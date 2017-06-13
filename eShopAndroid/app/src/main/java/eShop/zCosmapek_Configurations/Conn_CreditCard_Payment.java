package eShop.zCosmapek_Configurations;

import cosmapek.interfaces.IExecution;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: CreditCard
 * Component: Conn_CreditCard_Payment
 *
 * Manages the Conn_CreditCard_Payment configuration.
 */
public class Conn_CreditCard_Payment implements IExecution,IInterfaceTags {
    private creditCard.prov.IManager i_creditCard;
    private creditCard.prov.ICreditCardManager i_ICreditCardManager;

    private conn_CreditCard_Payment.prov.IManager i_conn_CreditCard_Payment;
    private payment.prov.IManager i_payment;

    @Override
    public synchronized void execute() {
        i_creditCard = creditCard.impl.ComponentFactory.createInstance();
        i_ICreditCardManager =
                (creditCard.prov.ICreditCardManager) i_creditCard.getProvidedInterface(ICreditCardManagerTag);

        i_conn_CreditCard_Payment= conn_CreditCard_Payment.impl.ComponentFactory.createInstance();
        i_conn_CreditCard_Payment.setRequiredInterface(ICreditCardManagerTag, i_ICreditCardManager);

        i_payment = payment.impl.ComponentFactory.createInstance();
        i_payment.setRequiredInterface(ICreditCardManagerTag,
                i_conn_CreditCard_Payment.getProvidedInterface(ICreditCardManagerTag));
    }
}