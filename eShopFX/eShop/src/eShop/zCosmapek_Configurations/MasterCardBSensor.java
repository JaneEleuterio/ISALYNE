package eShop.zCosmapek_Configurations;


import cosmapek.interfaces.IExecution;
import eShop.zCosmapek_Sensors.MasterCardBSensorThread;
import eShop.zCosmapek_Sensors.MasterCardBSensorThreadFactory;

import masterCardBSensor.prov.IManager;
import masterCardBSensor.prov.ISensorUpdaterManager;
import masterCardBSensor.impl.ComponentFactory;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardB
 * Component: MasterCardBSensor
 *
 * Manages the MasterCardBSensor configuration.
 */
public class MasterCardBSensor implements IExecution,IInterfaceTags {
    private IManager masterCardBSensor;
    private ISensorUpdaterManager masterCardBSensorISenUp;
    @Override
    public void execute() {
/*        masterCardBSensor = ComponentFactory.createInstance();
        masterCardBSensorISenUp =
                (ISensorUpdaterManager) masterCardBSensor.getProvidedInterface(ISensorUpdaterManagerTag);
*/
        MasterCardBSensorThread sensorThread = MasterCardBSensorThreadFactory.createInstance();
     //   sensorThread.start();
        if(!sensorThread.isAlive() && !MasterCardBSensorThreadFactory.wasUsed()){
            MasterCardBSensorThreadFactory.used();
            //Log.d("MasterCardB","MasterCardBSensor"+ sensorThread.getState().toString());
            sensorThread.start();
        }
    }
}