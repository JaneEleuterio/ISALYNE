package eShop.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardA
 * Component: Conn_MasterCardA_CreditCard
 *
 * Manages the Conn_MasterCardA_CreditCard configuration.
 */
public class Conn_MasterCardA_CreditCard implements IExecution,IInterfaceTags {
    private masterCardA.prov.IManager i_masterCardA;
    private masterCardA.prov.IMasterCardManager i_IMasterCardManager;

    private conn_MasterCardA_CreditCard.prov.IManager i_conn_MasterCardA_CreditCard;
    private creditCard.prov.IManager i_creditCard;

    @Override
    public synchronized void execute() {
        i_masterCardA = masterCardA.impl.ComponentFactory.createInstance();
        i_IMasterCardManager =
                (masterCardA.prov.IMasterCardManager) i_masterCardA.getProvidedInterface(IMasterCardManagerTag);

        i_conn_MasterCardA_CreditCard= conn_MasterCardA_CreditCard.impl.ComponentFactory.createInstance();
        i_conn_MasterCardA_CreditCard.setRequiredInterface(IMasterCardManagerTag, i_IMasterCardManager);

        i_creditCard = creditCard.impl.ComponentFactory.createInstance();
        i_creditCard.setRequiredInterface(IMasterCardManagerTag,
                i_conn_MasterCardA_CreditCard.getProvidedInterface(IMasterCardManagerTag));
    }
}