package visaCSensor.impl;

import visaCSensor.core.SensorUpdaterM;
import visaCSensor.core.SensorUpdaterMFactory;

import visaCSensor.prov.ISensorUpdaterManager;
import visaCSensor.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaC
 * Component: VisaCSensor
  *
 * This class is a part of the VisaCSensor sensor. This is used by Cosmapek Monitor componentName
 * to monitors the component 'VisaCSensor'. 
 */
class ISensorUpdaterManagerFacade implements visaCSensor.impl.IInterfaceTags, ISensorUpdaterManager {
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