package visaBSensor.core;

import visaBSensor.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaB
 * Component: VisaBSensor
 *
 * This class is a part of the VisaBSensor sensor. This is used by Cosmapek Monitor componentName
 * to monitors the component 'VisaBSensor'. 
 */
public class SensorUpdaterMFactory {
    private static visaBSensor.core.SensorUpdaterM sensorUpdaterM = null;

    public static synchronized visaBSensor.core.SensorUpdaterM createInstance(IManager manager) {
        if (sensorUpdaterM == null)
            sensorUpdaterM = new visaBSensor.core.SensorUpdaterM(manager);
        return sensorUpdaterM;
    }
}