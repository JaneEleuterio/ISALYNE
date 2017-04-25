package eShop.zCosmapek_Configurations;


import mapekcosmos.interfaces.IExecution;
import eShop.zCosmapek_Sensors.MasterCardASensorThread;
import eShop.zCosmapek_Sensors.MasterCardASensorThreadFactory;

import masterCardASensor.prov.IManager;
import masterCardASensor.prov.ISensorUpdaterManager;
import masterCardASensor.impl.ComponentFactory;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardA
 * Component: MasterCardASensor
 *
 * Manages the MasterCardASensor configuration.
 */
public class MasterCardASensor implements IExecution,IInterfaceTags {
    private IManager masterCardASensor;
    private ISensorUpdaterManager masterCardASensorISenUp;
    @Override
    public void execute() {
/*        masterCardASensor = ComponentFactory.createInstance();
        masterCardASensorISenUp =
                (ISensorUpdaterManager) masterCardASensor.getProvidedInterface(ISensorUpdaterManagerTag);
*/
        MasterCardASensorThread sensorThread = MasterCardASensorThreadFactory.createInstance();
     //   sensorThread.start();
        if(!sensorThread.isAlive() && !MasterCardASensorThreadFactory.wasUsed()){
            MasterCardASensorThreadFactory.used();
            //Log.d("MasterCardA","MasterCardASensor"+ sensorThread.getState().toString());
            sensorThread.start();
        }
    }
}