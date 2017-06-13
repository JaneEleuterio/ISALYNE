package masterCardBSensor.impl;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardB
 * Component: MasterCardBSensor
 *
 * This interface is a part of the MasterCardBSensor sensor. This is used by Cosmapek Monitor componentName
 * to monitors the component 'MasterCardBSensor'. 
 */
interface IInterfaceTags {
    //provided
    static final String IManagerProv = "IManager";
    static final String ISensorUpdaterManagerProv = "ISensorUpdaterManager";

    //required
    static final String ISensorUpdaterReq = "ISensorUpdater";
    static final String IMasterCardManagerReq = "IMasterCardManager";

}