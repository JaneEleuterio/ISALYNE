package controller.core;

import controller.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: App
 * Component: Controller
 */
public class ControllerMFactory {
    private static ControllerM controllerM = null;

    public static synchronized ControllerM createInstance(IManager manager) {
        if (controllerM == null)
            controllerM = new ControllerM(manager);
        return controllerM;
    }
}