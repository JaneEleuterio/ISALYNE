package conn_sensors_VisaASensor.impl;

import conn_sensors_VisaASensor.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaA
 * Component: Conn_sensors_VisaASensor
  *
 * This class is a part of the Conn_sensors_VisaASensor sensor. This is used by Cosmapek Monitor componentName
 * to monitors the component 'Conn_sensors_VisaASensor'. 
 */
class Adapter
    implements visaASensor.req.ISensorUpdater, conn_sensors_VisaASensor.impl.IInterfaceTags {
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