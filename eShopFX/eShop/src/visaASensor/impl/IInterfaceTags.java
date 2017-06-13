package visaASensor.impl;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaA
 * Component: VisaASensor
 *
 * This interface is a part of the VisaASensor sensor. This is used by Cosmapek Monitor componentName
 * to monitors the component 'VisaASensor'. 
 */
interface IInterfaceTags {
    //provided
    static final String IManagerProv = "IManager";
    static final String ISensorUpdaterManagerProv = "ISensorUpdaterManager";

    //required
    static final String ISensorUpdaterReq = "ISensorUpdater";
    static final String IVisaManagerReq = "IVisaManager";

}