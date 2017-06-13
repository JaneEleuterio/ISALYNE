package bankInvoice.core;

import bankInvoice.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: BankInvoice
 * Component: BankInvoice
 */
public class BankInvoiceMFactory {
    private static BankInvoiceM bankInvoiceM = null;

    public static synchronized BankInvoiceM createInstance(IManager manager) {
        if (bankInvoiceM == null)
            bankInvoiceM = new BankInvoiceM(manager);
        return bankInvoiceM;
    }
}