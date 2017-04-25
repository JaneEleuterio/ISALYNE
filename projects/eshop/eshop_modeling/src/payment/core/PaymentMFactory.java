package payment.core;

import payment.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: Payment
 * Component: Payment
 */
public class PaymentMFactory {
    private static PaymentM paymentM = null;

    public static synchronized PaymentM createInstance(IManager manager) {
        if (paymentM == null)
            paymentM = new PaymentM(manager);
        return paymentM;
    }
}