package eShop.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: BankInvoice
 * Component: Conn_BankInvoice_Payment
 *
 * Manages the Conn_BankInvoice_Payment configuration.
 */
public class Conn_BankInvoice_Payment implements IExecution,IInterfaceTags {
    private bankInvoice.prov.IManager i_bankInvoice;
    private bankInvoice.prov.IBankInvoiceManager i_IBankInvoiceManager;

    private conn_BankInvoice_Payment.prov.IManager i_conn_BankInvoice_Payment;
    private payment.prov.IManager i_payment;

    @Override
    public synchronized void execute() {
        i_bankInvoice = bankInvoice.impl.ComponentFactory.createInstance();
        i_IBankInvoiceManager =
                (bankInvoice.prov.IBankInvoiceManager) i_bankInvoice.getProvidedInterface(IBankInvoiceManagerTag);

        i_conn_BankInvoice_Payment= conn_BankInvoice_Payment.impl.ComponentFactory.createInstance();
        i_conn_BankInvoice_Payment.setRequiredInterface(IBankInvoiceManagerTag, i_IBankInvoiceManager);

        i_payment = payment.impl.ComponentFactory.createInstance();
        i_payment.setRequiredInterface(IBankInvoiceManagerTag,
                i_conn_BankInvoice_Payment.getProvidedInterface(IBankInvoiceManagerTag));
    }
}