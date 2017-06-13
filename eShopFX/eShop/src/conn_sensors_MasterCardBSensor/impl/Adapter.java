package conn_sensors_MasterCardBSensor.impl;

import conn_sensors_MasterCardBSensor.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardB
 * Component: Conn_sensors_MasterCardBSensor
  *
 * This class is a part of the Conn_sensors_MasterCardBSensor sensor. This is used by Cosmapek Monitor componentName
 * to monitors the component 'Conn_sensors_MasterCardBSensor'. 
 */
class Adapter
    implements masterCardBSensor.req.ISensorUpdater, conn_sensors_MasterCardBSensor.impl.IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }


    @Override
    public synchronized boolean activateSensor(String name) {
        cosmapek.sensors.prov.ISensorUpdater iSensorUpdater =
                (cosmapek.sensors.prov.ISensorUpdater) this.manager.getRequiredInterface(ISensorUpdaterTag);
        return iSensorUpdater.activateSensor(name);
    }

    @Override
    public synchronized boolean deactivateSensor(String name) {
        cosmapek.sensors.prov.ISensorUpdater iSensorUpdater =
                (cosmapek.sensors.prov.ISensorUpdater) this.manager.getRequiredInterface(ISensorUpdaterTag);
        return iSensorUpdater.deactivateSensor(name);
    }
}