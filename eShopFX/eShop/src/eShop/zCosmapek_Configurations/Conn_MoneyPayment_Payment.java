package eShop.zCosmapek_Configurations;

import cosmapek.interfaces.IExecution;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MoneyPayment
 * Component: Conn_MoneyPayment_Payment
 *
 * Manages the Conn_MoneyPayment_Payment configuration.
 */
public class Conn_MoneyPayment_Payment implements IExecution,IInterfaceTags {
    private moneyPayment.prov.IManager i_moneyPayment;
    private moneyPayment.prov.IMoneyPaymentManager i_IMoneyPaymentManager;

    private conn_MoneyPayment_Payment.prov.IManager i_conn_MoneyPayment_Payment;
    private payment.prov.IManager i_payment;

    @Override
    public synchronized void execute() {
        i_moneyPayment = moneyPayment.impl.ComponentFactory.createInstance();
        i_IMoneyPaymentManager =
                (moneyPayment.prov.IMoneyPaymentManager) i_moneyPayment.getProvidedInterface(IMoneyPaymentManagerTag);

        i_conn_MoneyPayment_Payment= conn_MoneyPayment_Payment.impl.ComponentFactory.createInstance();
        i_conn_MoneyPayment_Payment.setRequiredInterface(IMoneyPaymentManagerTag, i_IMoneyPaymentManager);

        i_payment = payment.impl.ComponentFactory.createInstance();
        i_payment.setRequiredInterface(IMoneyPaymentManagerTag,
                i_conn_MoneyPayment_Payment.getProvidedInterface(IMoneyPaymentManagerTag));
    }
}