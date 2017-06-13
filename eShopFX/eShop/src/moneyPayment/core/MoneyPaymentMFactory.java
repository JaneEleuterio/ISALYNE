package moneyPayment.core;

import moneyPayment.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MoneyPayment
 * Component: MoneyPayment
 */
public class MoneyPaymentMFactory {
    private static MoneyPaymentM moneyPaymentM = null;

    public static synchronized MoneyPaymentM createInstance(IManager manager) {
        if (moneyPaymentM == null)
            moneyPaymentM = new MoneyPaymentM(manager);
        return moneyPaymentM;
    }
}