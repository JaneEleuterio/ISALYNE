package eShop;

import java.io.File;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 *
 * Manages the threads and Cosmapek loop.
 */
public class MapeKCosmosThread extends Thread implements IInterfaceTags {
    private cosmapek.reader.prov.IManager reade;
    private cosmapek.reader.prov.IReadingManager readeIReading;
    private cosmapek.controller.prov.IManager controll;
    private cosmapek.controller.prov.IControllerManager controllIControll;

    String variabilityPath;
    String configPath;
    String jarPath;

    public MapeKCosmosThread(String variabilityPath, String configPath, String jarPath) {
        super();
        this.configPath=configPath;
        this.variabilityPath=variabilityPath;
        this.jarPath=jarPath;
    }

    @Override
    public void run() {
        //super.run();
        reade = cosmapek.reader.impl.ComponentFactory.createInstance();
        readeIReading =
                (cosmapek.reader.prov.IReadingManager) reade.getProvidedInterface(IReadingManagerTag);

        controll = cosmapek.controller.impl.ComponentFactory.createInstance();
        controllIControll = (cosmapek.controller.prov.IControllerManager) controll
                .getProvidedInterface(IControllerManagerTag);


        String configuration_Path = this.configPath;
        String variability_Path   = this.variabilityPath;
        //to load the mapekcosmos.components
        readeIReading.setConfigurationPath(configuration_Path);
        readeIReading.setVariabilityPath(variability_Path);
        readeIReading.read();

        controllIControll.setJarPath(jarPath);

        //the loop
		// in milliseconds
        long monitoringTimeLapse = 5*1000;
        controllIControll.setTimeLapse(monitoringTimeLapse);

        controllIControll.execute();

       controllIControll.monitor();// here is the control loop
    }

}