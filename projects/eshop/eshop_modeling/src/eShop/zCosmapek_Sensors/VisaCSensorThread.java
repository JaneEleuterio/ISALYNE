package eShop.zCosmapek_Sensors;


import visaCSensor.impl.ComponentFactory;
import visaCSensor.prov.ISensorUpdaterManager;
import visaCSensor.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaC
 * Component: VisaCSensor
 *
 * Manages the VisaCSensor sensor threads
 */
 
public class VisaCSensorThread extends Thread implements IInterfaceTags {
    private IManager visaCSensor;
    private ISensorUpdaterManager visaCSensorISenUp;
    @Override
    public void run() {
        //super.run();
        visaCSensor = ComponentFactory.createInstance();
        visaCSensorISenUp =
                (ISensorUpdaterManager) visaCSensor.getProvidedInterface(ISensorUpdaterManagerTag);
        visaCSensorISenUp.runSensor();
    }
}