package conn_sensors_VisaBSensor.impl;

import conn_sensors_VisaBSensor.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaB
 * Component: Conn_sensors_VisaBSensor
  *
 * This class is a part of the Conn_sensors_VisaBSensor sensor. This is used by Cosmapek Monitor componentName
 * to monitors the component 'Conn_sensors_VisaBSensor'. 
 */
class Adapter
    implements visaBSensor.req.ISensorUpdater, conn_sensors_VisaBSensor.impl.IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }


    @Override
    public synchronized boolean activateSensor(String name) {
        mapekcosmos.sensors.prov.ISensorUpdater iSensorUpdater =
                (mapekcosmos.sensors.prov.ISensorUpdater) this.manager.getRequiredInterface(ISensorUpdaterTag);
        return iSensorUpdater.activateSensor(name);
    }

    @Override
    public synchronized boolean deactivateSensor(String name) {
        mapekcosmos.sensors.prov.ISensorUpdater iSensorUpdater =
                (mapekcosmos.sensors.prov.ISensorUpdater) this.manager.getRequiredInterface(ISensorUpdaterTag);
        return iSensorUpdater.deactivateSensor(name);
    }
}