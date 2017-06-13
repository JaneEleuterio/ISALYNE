package eShop.zCosmapek_Configurations;


import cosmapek.interfaces.IExecution;
import eShop.zCosmapek_Sensors.VisaBSensorThread;
import eShop.zCosmapek_Sensors.VisaBSensorThreadFactory;

import visaBSensor.prov.IManager;
import visaBSensor.prov.ISensorUpdaterManager;
import visaBSensor.impl.ComponentFactory;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaB
 * Component: VisaBSensor
 *
 * Manages the VisaBSensor configuration.
 */
public class VisaBSensor implements IExecution,IInterfaceTags {
    private IManager visaBSensor;
    private ISensorUpdaterManager visaBSensorISenUp;
    @Override
    public void execute() {
/*        visaBSensor = ComponentFactory.createInstance();
        visaBSensorISenUp =
                (ISensorUpdaterManager) visaBSensor.getProvidedInterface(ISensorUpdaterManagerTag);
*/
        VisaBSensorThread sensorThread = VisaBSensorThreadFactory.createInstance();
     //   sensorThread.start();
        if(!sensorThread.isAlive() && !VisaBSensorThreadFactory.wasUsed()){
            VisaBSensorThreadFactory.used();
            //Log.d("VisaB","VisaBSensor"+ sensorThread.getState().toString());
            sensorThread.start();
        }
    }
}