package cosmapek.main.core;

import cosmapek.main.prov.IManager;
import cosmapek.main.req.IControllerManager;
import cosmapek.main.req.IReadingManager;

import java.io.File;
import java.net.URI;

/**
 * This is the cosmapek.main class of the component Main
 *
 * @author Junior Cupe Casquina
 */
public class Boot implements IInterfaceTags {
    private IManager manager;
    private IControllerManager controller;
    private IReadingManager reader;

    public Boot(IManager manager) {
        this.manager = manager;
    }

    private void getManagers() {
        controller = (IControllerManager) manager.getRequiredInterface(IControllerManagerReq);
        reader = (IReadingManager) manager.getRequiredInterface(IReadingManagerReq);
    }

    public boolean start() {
        getManagers();
        String jarPath = "executers";
        String configurationPath =
            "file:///C:/Users/ArchyWin/Dropbox/Codigos/wsJunior/cosmapek/resources/config.xml";
        String variabilityPath =
            "file:///C:/Users/ArchyWin/Dropbox/Codigos/wsJunior/cosmapek/resources/variability.xml";

        File inputConfigurationPath = new File(URI.create(configurationPath));
        File inputVariabilityPath = new File(URI.create(variabilityPath));

        //to load the cosmapek.components
        reader.setConfigurationPath(inputConfigurationPath.getPath());
        reader.setVariabilityPath(inputVariabilityPath.getPath());
        reader.read();
        controller.setJarPath(jarPath);
        controller.execute();

        //the loop
        long monitoringTimeLapse = 2000; // in milliseconds
        controller.setTimeLapse(monitoringTimeLapse);
        controller.monitor();// here is the control loop
        return true;
    }
}
