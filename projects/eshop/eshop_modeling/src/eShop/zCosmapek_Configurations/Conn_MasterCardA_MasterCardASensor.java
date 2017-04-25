package eShop.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardA
 * Component: Conn_MasterCardA_MasterCardASensor
 *
 * Manages the Conn_MasterCardA_MasterCardASensor configuration.
 */
public class Conn_MasterCardA_MasterCardASensor implements IExecution,IInterfaceTags {
    private masterCardA.prov.IManager i_masterCardA;
    private masterCardA.prov.IMasterCardManager i_IMasterCardManager;

    private conn_MasterCardA_MasterCardASensor.prov.IManager i_conn_MasterCardA_MasterCardASensor;
    private masterCardASensor.prov.IManager i_masterCardASensor;

    @Override
    public synchronized void execute() {
        i_masterCardA = masterCardA.impl.ComponentFactory.createInstance();
        i_IMasterCardManager =
                (masterCardA.prov.IMasterCardManager) i_masterCardA.getProvidedInterface(IMasterCardManagerTag);

        i_conn_MasterCardA_MasterCardASensor= conn_MasterCardA_MasterCardASensor.impl.ComponentFactory.createInstance();
        i_conn_MasterCardA_MasterCardASensor.setRequiredInterface(IMasterCardManagerTag, i_IMasterCardManager);

        i_masterCardASensor = masterCardASensor.impl.ComponentFactory.createInstance();
        i_masterCardASensor.setRequiredInterface(IMasterCardManagerTag,
                i_conn_MasterCardA_MasterCardASensor.getProvidedInterface(IMasterCardManagerTag));
    }
}