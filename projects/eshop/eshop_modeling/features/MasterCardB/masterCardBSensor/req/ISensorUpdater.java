package masterCardBSensor.req;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardB
 * Component: MasterCardBSensor
 *
 *
 * This interface is a part of the MasterCardBSensor sensor. This is used by Cosmapek Monitor componentName
 * to monitors the component 'MasterCardBSensor'. 
 */
public interface ISensorUpdater {
    boolean activateSensor(String name);

    boolean deactivateSensor(String name);
}