package masterCardASensor.prov;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardA
 * Component: MasterCardASensor
 *
 * This interface is a part of the MasterCardASensor sensor. This is used by Cosmapek Monitor componentName
 * to monitors the component 'MasterCardASensor'. 
 */
public interface ISensorUpdaterManager {
    boolean runSensor();

    boolean deactivateSensor();
}