package eShop.zCosmapek_Configurations;

import cosmapek.interfaces.IExecution;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardB
 * Component: Conn_sensors_MasterCardBSensor
 *
 * Manages the Conn_sensors_MasterCardBSensor configuration.
 */
public class Conn_sensors_MasterCardBSensor implements IExecution,IInterfaceTags {
    private cosmapek.sensors.prov.IManager sens;
    private cosmapek.sensors.prov.ISensorUpdater sensISens;

    private conn_sensors_MasterCardBSensor.prov.IManager i_conn_sensors_MasterCardBSensor;
    private masterCardBSensor.prov.IManager i_masterCardBSensor;
    @Override
    public synchronized void execute() {
        sens = cosmapek.sensors.impl.ComponentFactory.createInstance();
        sensISens = (cosmapek.sensors.prov.ISensorUpdater) sens.getProvidedInterface(ISensorUpdaterTag);

        i_conn_sensors_MasterCardBSensor=conn_sensors_MasterCardBSensor.impl.ComponentFactory.createInstance();
        i_conn_sensors_MasterCardBSensor.setRequiredInterface(ISensorUpdaterTag, sensISens);

        i_masterCardBSensor = masterCardBSensor.impl.ComponentFactory.createInstance();
        i_masterCardBSensor.setRequiredInterface(ISensorUpdaterTag,
                i_conn_sensors_MasterCardBSensor.getProvidedInterface(ISensorUpdaterTag));
    }
}