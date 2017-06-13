package visaCSensor.core;

import visaCSensor.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaC
 * Component: VisaCSensor
 *
 * This class is a part of the VisaCSensor sensor. This is used by Cosmapek Monitor componentName
 * to monitors the component 'VisaCSensor'. 
 */
public class SensorUpdaterMFactory {
    private static visaCSensor.core.SensorUpdaterM sensorUpdaterM = null;

    public static synchronized visaCSensor.core.SensorUpdaterM createInstance(IManager manager) {
        if (sensorUpdaterM == null)
            sensorUpdaterM = new visaCSensor.core.SensorUpdaterM(manager);
        return sensorUpdaterM;
    }
}