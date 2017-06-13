package eShop.zCosmapek_Configurations;

import cosmapek.interfaces.IExecution;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardB
 * Component: Conn_MasterCardB_CreditCard
 *
 * Manages the Conn_MasterCardB_CreditCard configuration.
 */
public class Conn_MasterCardB_CreditCard implements IExecution,IInterfaceTags {
    private masterCardB.prov.IManager i_masterCardB;
    private masterCardB.prov.IMasterCardManager i_IMasterCardManager;

    private conn_MasterCardB_CreditCard.prov.IManager i_conn_MasterCardB_CreditCard;
    private creditCard.prov.IManager i_creditCard;

    @Override
    public synchronized void execute() {
        i_masterCardB = masterCardB.impl.ComponentFactory.createInstance();
        i_IMasterCardManager =
                (masterCardB.prov.IMasterCardManager) i_masterCardB.getProvidedInterface(IMasterCardManagerTag);

        i_conn_MasterCardB_CreditCard= conn_MasterCardB_CreditCard.impl.ComponentFactory.createInstance();
        i_conn_MasterCardB_CreditCard.setRequiredInterface(IMasterCardManagerTag, i_IMasterCardManager);

        i_creditCard = creditCard.impl.ComponentFactory.createInstance();
        i_creditCard.setRequiredInterface(IMasterCardManagerTag,
                i_conn_MasterCardB_CreditCard.getProvidedInterface(IMasterCardManagerTag));
    }
}