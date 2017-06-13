package visaASensor.core;

import visaASensor.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaA
 * Component: VisaASensor
 *
 * This class is a part of the VisaASensor sensor. This is used by Cosmapek Monitor componentName
 * to monitors the component 'VisaASensor'. 
 */
public class SensorUpdaterMFactory {
    private static visaASensor.core.SensorUpdaterM sensorUpdaterM = null;

    public static synchronized visaASensor.core.SensorUpdaterM createInstance(IManager manager) {
        if (sensorUpdaterM == null)
            sensorUpdaterM = new visaASensor.core.SensorUpdaterM(manager);
        return sensorUpdaterM;
    }
}