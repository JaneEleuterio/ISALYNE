package eShop.zCosmapek_Configurations;

import cosmapek.interfaces.IExecution;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: BankTransfer
 * Component: Conn_BankTransfer_Payment
 *
 * Manages the Conn_BankTransfer_Payment configuration.
 */
public class Conn_BankTransfer_Payment implements IExecution,IInterfaceTags {
    private bankTransfer.prov.IManager i_bankTransfer;
    private bankTransfer.prov.IBankTransferManager i_IBankTransferManager;

    private conn_BankTransfer_Payment.prov.IManager i_conn_BankTransfer_Payment;
    private payment.prov.IManager i_payment;

    @Override
    public synchronized void execute() {
        i_bankTransfer = bankTransfer.impl.ComponentFactory.createInstance();
        i_IBankTransferManager =
                (bankTransfer.prov.IBankTransferManager) i_bankTransfer.getProvidedInterface(IBankTransferManagerTag);

        i_conn_BankTransfer_Payment= conn_BankTransfer_Payment.impl.ComponentFactory.createInstance();
        i_conn_BankTransfer_Payment.setRequiredInterface(IBankTransferManagerTag, i_IBankTransferManager);

        i_payment = payment.impl.ComponentFactory.createInstance();
        i_payment.setRequiredInterface(IBankTransferManagerTag,
                i_conn_BankTransfer_Payment.getProvidedInterface(IBankTransferManagerTag));
    }
}