package eShop.zCosmapek_Sensors;


import masterCardASensor.impl.ComponentFactory;
import masterCardASensor.prov.ISensorUpdaterManager;
import masterCardASensor.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardA
 * Component: MasterCardASensor
 *
 * Manages the MasterCardASensor sensor threads
 */
 
public class MasterCardASensorThread extends Thread implements IInterfaceTags {
    private IManager masterCardASensor;
    private ISensorUpdaterManager masterCardASensorISenUp;
    @Override
    public void run() {
        //super.run();
        masterCardASensor = ComponentFactory.createInstance();
        masterCardASensorISenUp =
                (ISensorUpdaterManager) masterCardASensor.getProvidedInterface(ISensorUpdaterManagerTag);
        masterCardASensorISenUp.runSensor();
    }
}