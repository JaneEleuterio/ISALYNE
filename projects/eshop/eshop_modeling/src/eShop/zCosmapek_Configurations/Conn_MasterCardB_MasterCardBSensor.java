package eShop.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardB
 * Component: Conn_MasterCardB_MasterCardBSensor
 *
 * Manages the Conn_MasterCardB_MasterCardBSensor configuration.
 */
public class Conn_MasterCardB_MasterCardBSensor implements IExecution,IInterfaceTags {
    private masterCardB.prov.IManager i_masterCardB;
    private masterCardB.prov.IMasterCardManager i_IMasterCardManager;

    private conn_MasterCardB_MasterCardBSensor.prov.IManager i_conn_MasterCardB_MasterCardBSensor;
    private masterCardBSensor.prov.IManager i_masterCardBSensor;

    @Override
    public synchronized void execute() {
        i_masterCardB = masterCardB.impl.ComponentFactory.createInstance();
        i_IMasterCardManager =
                (masterCardB.prov.IMasterCardManager) i_masterCardB.getProvidedInterface(IMasterCardManagerTag);

        i_conn_MasterCardB_MasterCardBSensor= conn_MasterCardB_MasterCardBSensor.impl.ComponentFactory.createInstance();
        i_conn_MasterCardB_MasterCardBSensor.setRequiredInterface(IMasterCardManagerTag, i_IMasterCardManager);

        i_masterCardBSensor = masterCardBSensor.impl.ComponentFactory.createInstance();
        i_masterCardBSensor.setRequiredInterface(IMasterCardManagerTag,
                i_conn_MasterCardB_MasterCardBSensor.getProvidedInterface(IMasterCardManagerTag));
    }
}