package eShop.zCosmapek_Sensors;


import visaASensor.impl.ComponentFactory;
import visaASensor.prov.ISensorUpdaterManager;
import visaASensor.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaA
 * Component: VisaASensor
 *
 * Manages the VisaASensor sensor threads
 */
 
public class VisaASensorThread extends Thread implements IInterfaceTags {
    private IManager visaASensor;
    private ISensorUpdaterManager visaASensorISenUp;
    @Override
    public void run() {
        //super.run();
        visaASensor = ComponentFactory.createInstance();
        visaASensorISenUp =
                (ISensorUpdaterManager) visaASensor.getProvidedInterface(ISensorUpdaterManagerTag);
        visaASensorISenUp.runSensor();
    }
}