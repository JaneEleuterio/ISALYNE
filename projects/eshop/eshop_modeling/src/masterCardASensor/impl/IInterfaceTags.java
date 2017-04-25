package masterCardASensor.impl;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardA
 * Component: MasterCardASensor
 *
 * This interface is a part of the MasterCardASensor sensor. This is used by Cosmapek Monitor componentName
 * to monitors the component 'MasterCardASensor'. 
 */
interface IInterfaceTags {
    //provided
    static final String IManagerProv = "IManager";
    static final String ISensorUpdaterManagerProv = "ISensorUpdaterManager";

    //required
    static final String ISensorUpdaterReq = "ISensorUpdater";
    static final String IMasterCardManagerReq = "IMasterCardManager";

}