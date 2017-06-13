package cosmapek.conn_sensors_variability.impl;

import cosmapek.conn_sensors_variability.prov.IManager;

import java.util.LinkedList;

class Adapter
    implements cosmapek.variability.req.ISensorManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized void updateRuntimeRegistry(LinkedList<String> sol) {
        cosmapek.sensors.prov.ISensorManager compSensors =
            (cosmapek.sensors.prov.ISensorManager) this.manager.getRequiredInterface(ISensorManagerTag);
        compSensors.updateRuntimeRegistry(sol);
    }
}
