package masterCardASensor.core;

import masterCardASensor.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardA
 * Component: MasterCardASensor
 *
 * This class is a part of the MasterCardASensor sensor. This is used by Cosmapek Monitor componentName
 * to monitors the component 'MasterCardASensor'. 
 */
public class SensorUpdaterMFactory {
    private static masterCardASensor.core.SensorUpdaterM sensorUpdaterM = null;

    public static synchronized masterCardASensor.core.SensorUpdaterM createInstance(IManager manager) {
        if (sensorUpdaterM == null)
            sensorUpdaterM = new masterCardASensor.core.SensorUpdaterM(manager);
        return sensorUpdaterM;
    }
}