package eShop.zCosmapek_Configurations;


import mapekcosmos.interfaces.IExecution;
import eShop.zCosmapek_Sensors.VisaCSensorThread;
import eShop.zCosmapek_Sensors.VisaCSensorThreadFactory;

import visaCSensor.prov.IManager;
import visaCSensor.prov.ISensorUpdaterManager;
import visaCSensor.impl.ComponentFactory;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaC
 * Component: VisaCSensor
 *
 * Manages the VisaCSensor configuration.
 */
public class VisaCSensor implements IExecution,IInterfaceTags {
    private IManager visaCSensor;
    private ISensorUpdaterManager visaCSensorISenUp;
    @Override
    public void execute() {
/*        visaCSensor = ComponentFactory.createInstance();
        visaCSensorISenUp =
                (ISensorUpdaterManager) visaCSensor.getProvidedInterface(ISensorUpdaterManagerTag);
*/
        VisaCSensorThread sensorThread = VisaCSensorThreadFactory.createInstance();
     //   sensorThread.start();
        if(!sensorThread.isAlive() && !VisaCSensorThreadFactory.wasUsed()){
            VisaCSensorThreadFactory.used();
            //Log.d("VisaC","VisaCSensor"+ sensorThread.getState().toString());
            sensorThread.start();
        }
    }
}