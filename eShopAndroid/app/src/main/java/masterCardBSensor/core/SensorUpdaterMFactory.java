package masterCardBSensor.core;

import masterCardBSensor.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardB
 * Component: MasterCardBSensor
 *
 * This class is a part of the MasterCardBSensor sensor. This is used by Cosmapek Monitor componentName
 * to monitors the component 'MasterCardBSensor'. 
 */
public class SensorUpdaterMFactory {
    private static masterCardBSensor.core.SensorUpdaterM sensorUpdaterM = null;

    public static synchronized masterCardBSensor.core.SensorUpdaterM createInstance(IManager manager) {
        if (sensorUpdaterM == null)
            sensorUpdaterM = new masterCardBSensor.core.SensorUpdaterM(manager);
        return sensorUpdaterM;
    }
}