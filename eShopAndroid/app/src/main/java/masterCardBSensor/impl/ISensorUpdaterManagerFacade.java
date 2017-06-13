package masterCardBSensor.impl;

import masterCardBSensor.core.SensorUpdaterM;
import masterCardBSensor.core.SensorUpdaterMFactory;

import masterCardBSensor.prov.ISensorUpdaterManager;
import masterCardBSensor.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardB
 * Component: MasterCardBSensor
  *
 * This class is a part of the MasterCardBSensor sensor. This is used by Cosmapek Monitor componentName
 * to monitors the component 'MasterCardBSensor'. 
 */
class ISensorUpdaterManagerFacade implements masterCardBSensor.impl.IInterfaceTags, ISensorUpdaterManager {
    private IManager manager = null;
    private SensorUpdaterM sensorUpdaterM;

    ISensorUpdaterManagerFacade(IManager manager) {
        this.manager = manager;
        this.sensorUpdaterM = SensorUpdaterMFactory.createInstance(this.manager);
    }

    @Override
    public synchronized boolean runSensor() {
        return sensorUpdaterM.runSensor();
    }

    @Override
    public synchronized boolean deactivateSensor() {
        return sensorUpdaterM.deactivateSensor();
    }
}