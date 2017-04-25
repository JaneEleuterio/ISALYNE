package eShop.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardA
 * Component: Conn_sensors_MasterCardASensor
 *
 * Manages the Conn_sensors_MasterCardASensor configuration.
 */
public class Conn_sensors_MasterCardASensor implements IExecution,IInterfaceTags {
    private mapekcosmos.sensors.prov.IManager sens;
    private mapekcosmos.sensors.prov.ISensorUpdater sensISens;

    private conn_sensors_MasterCardASensor.prov.IManager i_conn_sensors_MasterCardASensor;
    private masterCardASensor.prov.IManager i_masterCardASensor;
    @Override
    public synchronized void execute() {
        sens = mapekcosmos.sensors.impl.ComponentFactory.createInstance();
        sensISens = (mapekcosmos.sensors.prov.ISensorUpdater) sens.getProvidedInterface(ISensorUpdaterTag);

        i_conn_sensors_MasterCardASensor=conn_sensors_MasterCardASensor.impl.ComponentFactory.createInstance();
        i_conn_sensors_MasterCardASensor.setRequiredInterface(ISensorUpdaterTag, sensISens);

        i_masterCardASensor = masterCardASensor.impl.ComponentFactory.createInstance();
        i_masterCardASensor.setRequiredInterface(ISensorUpdaterTag,
                i_conn_sensors_MasterCardASensor.getProvidedInterface(ISensorUpdaterTag));
    }
}