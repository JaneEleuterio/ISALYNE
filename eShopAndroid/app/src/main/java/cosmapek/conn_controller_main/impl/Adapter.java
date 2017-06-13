package cosmapek.conn_controller_main.impl;

import cosmapek.conn_controller_main.prov.IManager;

class Adapter implements cosmapek.main.req.IControllerManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized void execute() {
        cosmapek.controller.prov.IControllerManager compController =
            (cosmapek.controller.prov.IControllerManager) this.manager
                .getRequiredInterface(IControllerManagerTag);
        compController.execute();
    }

    @Override public synchronized void setTimeLapse(long monitoringTimeLapse) {
        cosmapek.controller.prov.IControllerManager compController =
            (cosmapek.controller.prov.IControllerManager) this.manager
                .getRequiredInterface(IControllerManagerTag);
        compController.setTimeLapse(monitoringTimeLapse);
    }

    @Override public synchronized void monitor() {
        cosmapek.controller.prov.IControllerManager compController =
            (cosmapek.controller.prov.IControllerManager) this.manager
                .getRequiredInterface(IControllerManagerTag);
        compController.monitor();
    }

    @Override public synchronized void setJarPath(String jarPath) {
        cosmapek.controller.prov.IControllerManager compController =
            (cosmapek.controller.prov.IControllerManager) this.manager
                .getRequiredInterface(IControllerManagerTag);
        compController.setJarPath(jarPath);
    }
}
