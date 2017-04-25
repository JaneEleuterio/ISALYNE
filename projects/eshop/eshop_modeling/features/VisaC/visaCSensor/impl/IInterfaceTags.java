package visaCSensor.impl;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaC
 * Component: VisaCSensor
 *
 * This interface is a part of the VisaCSensor sensor. This is used by Cosmapek Monitor componentName
 * to monitors the component 'VisaCSensor'. 
 */
interface IInterfaceTags {
    //provided
    static final String IManagerProv = "IManager";
    static final String ISensorUpdaterManagerProv = "ISensorUpdaterManager";

    //required
    static final String ISensorUpdaterReq = "ISensorUpdater";
    static final String IVisaManagerReq = "IVisaManager";

}