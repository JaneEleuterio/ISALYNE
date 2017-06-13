package visaCSensor.req;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaC
 * Component: VisaCSensor
 *
 *
 * This interface is a part of the VisaCSensor sensor. This is used by Cosmapek Monitor componentName
 * to monitors the component 'VisaCSensor'. 
 */
public interface ISensorUpdater {
    boolean activateSensor(String name);

    boolean deactivateSensor(String name);
}