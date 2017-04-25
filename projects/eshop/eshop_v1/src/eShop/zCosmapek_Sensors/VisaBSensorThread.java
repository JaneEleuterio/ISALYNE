package eShop.zCosmapek_Sensors;


import visaBSensor.impl.ComponentFactory;
import visaBSensor.prov.ISensorUpdaterManager;
import visaBSensor.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaB
 * Component: VisaBSensor
 *
 * Manages the VisaBSensor sensor threads
 */
 
public class VisaBSensorThread extends Thread implements IInterfaceTags {
    private IManager visaBSensor;
    private ISensorUpdaterManager visaBSensorISenUp;
    @Override
    public void run() {
        //super.run();
        visaBSensor = ComponentFactory.createInstance();
        visaBSensorISenUp =
                (ISensorUpdaterManager) visaBSensor.getProvidedInterface(ISensorUpdaterManagerTag);
        visaBSensorISenUp.runSensor();
    }
}