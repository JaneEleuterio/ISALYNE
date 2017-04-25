package bankTransfer.core;

import bankTransfer.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: BankTransfer
 * Component: BankTransfer
 */
public class BankTransferMFactory {
    private static BankTransferM bankTransferM = null;

    public static synchronized BankTransferM createInstance(IManager manager) {
        if (bankTransferM == null)
            bankTransferM = new BankTransferM(manager);
        return bankTransferM;
    }
}