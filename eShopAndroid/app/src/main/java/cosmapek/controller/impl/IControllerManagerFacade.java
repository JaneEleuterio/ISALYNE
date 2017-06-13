package cosmapek.controller.impl;

import cosmapek.controller.core.Monitor;
import cosmapek.controller.core.MonitorFactory;
import cosmapek.controller.prov.IControllerManager;
import cosmapek.controller.prov.IManager;

/**
 * @author Junior Cupe Casquina
 */
class IControllerManagerFacade implements IControllerManager {
    private IManager manager;
    private Monitor monitor;

    IControllerManagerFacade(IManager manager) {
        this.manager = manager;
        monitor = MonitorFactory.createInstance(this.manager);
    }

    @Override public synchronized void execute() {
        monitor.execute();
    }

    @Override public synchronized void setTimeLapse(long monitoringTimeLapse) {
        monitor.setTimeLapse(monitoringTimeLapse);
    }

    @Override public synchronized void monitor() {
        monitor.monitor();
    }

    @Override public synchronized void setJarPath(String jarPath) {
        monitor.setJarPath(jarPath);
    }
}
