package creditCard.core;

import creditCard.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: CreditCard
 * Component: CreditCard
 */
public class CreditCardMFactory {
    private static CreditCardM creditCardM = null;

    public static synchronized CreditCardM createInstance(IManager manager) {
        if (creditCardM == null)
            creditCardM = new CreditCardM(manager);
        return creditCardM;
    }
}