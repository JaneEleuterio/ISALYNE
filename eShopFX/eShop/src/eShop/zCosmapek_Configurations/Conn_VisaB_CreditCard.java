package eShop.zCosmapek_Configurations;

import cosmapek.interfaces.IExecution;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaB
 * Component: Conn_VisaB_CreditCard
 *
 * Manages the Conn_VisaB_CreditCard configuration.
 */
public class Conn_VisaB_CreditCard implements IExecution,IInterfaceTags {
    private visaB.prov.IManager i_visaB;
    private visaB.prov.IVisaManager i_IVisaManager;

    private conn_VisaB_CreditCard.prov.IManager i_conn_VisaB_CreditCard;
    private creditCard.prov.IManager i_creditCard;

    @Override
    public synchronized void execute() {
        i_visaB = visaB.impl.ComponentFactory.createInstance();
        i_IVisaManager =
                (visaB.prov.IVisaManager) i_visaB.getProvidedInterface(IVisaManagerTag);

        i_conn_VisaB_CreditCard= conn_VisaB_CreditCard.impl.ComponentFactory.createInstance();
        i_conn_VisaB_CreditCard.setRequiredInterface(IVisaManagerTag, i_IVisaManager);

        i_creditCard = creditCard.impl.ComponentFactory.createInstance();
        i_creditCard.setRequiredInterface(IVisaManagerTag,
                i_conn_VisaB_CreditCard.getProvidedInterface(IVisaManagerTag));
    }
}