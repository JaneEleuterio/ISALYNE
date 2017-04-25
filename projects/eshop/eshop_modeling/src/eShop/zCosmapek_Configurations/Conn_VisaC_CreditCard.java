package eShop.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaC
 * Component: Conn_VisaC_CreditCard
 *
 * Manages the Conn_VisaC_CreditCard configuration.
 */
public class Conn_VisaC_CreditCard implements IExecution,IInterfaceTags {
    private visaC.prov.IManager i_visaC;
    private visaC.prov.IVisaManager i_IVisaManager;

    private conn_VisaC_CreditCard.prov.IManager i_conn_VisaC_CreditCard;
    private creditCard.prov.IManager i_creditCard;

    @Override
    public synchronized void execute() {
        i_visaC = visaC.impl.ComponentFactory.createInstance();
        i_IVisaManager =
                (visaC.prov.IVisaManager) i_visaC.getProvidedInterface(IVisaManagerTag);

        i_conn_VisaC_CreditCard= conn_VisaC_CreditCard.impl.ComponentFactory.createInstance();
        i_conn_VisaC_CreditCard.setRequiredInterface(IVisaManagerTag, i_IVisaManager);

        i_creditCard = creditCard.impl.ComponentFactory.createInstance();
        i_creditCard.setRequiredInterface(IVisaManagerTag,
                i_conn_VisaC_CreditCard.getProvidedInterface(IVisaManagerTag));
    }
}