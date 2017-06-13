package visaBSensor.req;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaB
 * Component: VisaBSensor
 *
 *
 * This interface is a part of the VisaBSensor sensor. This is used by Cosmapek Monitor componentName
 * to monitors the component 'VisaBSensor'. 
 */
public interface ISensorUpdater {
    boolean activateSensor(String name);

    boolean deactivateSensor(String name);
}