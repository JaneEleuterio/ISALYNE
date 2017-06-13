package eShop.zCosmapek_Sensors;


import masterCardBSensor.impl.ComponentFactory;
import masterCardBSensor.prov.ISensorUpdaterManager;
import masterCardBSensor.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardB
 * Component: MasterCardBSensor
 *
 * Manages the MasterCardBSensor sensor threads
 */
 
public class MasterCardBSensorThread extends Thread implements IInterfaceTags {
    private IManager masterCardBSensor;
    private ISensorUpdaterManager masterCardBSensorISenUp;
    @Override
    public void run() {
        //super.run();
        masterCardBSensor = ComponentFactory.createInstance();
        masterCardBSensorISenUp =
                (ISensorUpdaterManager) masterCardBSensor.getProvidedInterface(ISensorUpdaterManagerTag);
        masterCardBSensorISenUp.runSensor();
    }
}