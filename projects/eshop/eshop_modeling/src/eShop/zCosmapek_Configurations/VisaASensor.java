package eShop.zCosmapek_Configurations;


import mapekcosmos.interfaces.IExecution;
import eShop.zCosmapek_Sensors.VisaASensorThread;
import eShop.zCosmapek_Sensors.VisaASensorThreadFactory;

import visaASensor.prov.IManager;
import visaASensor.prov.ISensorUpdaterManager;
import visaASensor.impl.ComponentFactory;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaA
 * Component: VisaASensor
 *
 * Manages the VisaASensor configuration.
 */
public class VisaASensor implements IExecution,IInterfaceTags {
    private IManager visaASensor;
    private ISensorUpdaterManager visaASensorISenUp;
    @Override
    public void execute() {
/*        visaASensor = ComponentFactory.createInstance();
        visaASensorISenUp =
                (ISensorUpdaterManager) visaASensor.getProvidedInterface(ISensorUpdaterManagerTag);
*/
        VisaASensorThread sensorThread = VisaASensorThreadFactory.createInstance();
     //   sensorThread.start();
        if(!sensorThread.isAlive() && !VisaASensorThreadFactory.wasUsed()){
            VisaASensorThreadFactory.used();
            //Log.d("VisaA","VisaASensor"+ sensorThread.getState().toString());
            sensorThread.start();
        }
    }
}