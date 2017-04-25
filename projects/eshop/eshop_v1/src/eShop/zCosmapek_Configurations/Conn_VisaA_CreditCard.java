package eShop.zCosmapek_Configurations;

import cosmapek.interfaces.IExecution;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaA
 * Component: Conn_VisaA_CreditCard
 *
 * Manages the Conn_VisaA_CreditCard configuration.
 */
public class Conn_VisaA_CreditCard implements IExecution,IInterfaceTags {
    private visaA.prov.IManager i_visaA;
    private visaA.prov.IVisaManager i_IVisaManager;

    private conn_VisaA_CreditCard.prov.IManager i_conn_VisaA_CreditCard;
    private creditCard.prov.IManager i_creditCard;

    @Override
    public synchronized void execute() {
        i_visaA = visaA.impl.ComponentFactory.createInstance();
        i_IVisaManager =
                (visaA.prov.IVisaManager) i_visaA.getProvidedInterface(IVisaManagerTag);

        i_conn_VisaA_CreditCard= conn_VisaA_CreditCard.impl.ComponentFactory.createInstance();
        i_conn_VisaA_CreditCard.setRequiredInterface(IVisaManagerTag, i_IVisaManager);

        i_creditCard = creditCard.impl.ComponentFactory.createInstance();
        i_creditCard.setRequiredInterface(IVisaManagerTag,
                i_conn_VisaA_CreditCard.getProvidedInterface(IVisaManagerTag));
    }
}