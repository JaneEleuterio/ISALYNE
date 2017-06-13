package cosmapek.conn_sensors_planner.impl;

import cosmapek.conn_sensors_planner.prov.IManager;
import cosmapek.interfaces.ISensor;

import java.util.LinkedList;

class Adapter implements cosmapek.planner.req.ISensorManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized LinkedList<ISensor> getSensorsWith(String feature) {
        cosmapek.sensors.prov.ISensorManager compSensors =
            (cosmapek.sensors.prov.ISensorManager) this.manager.getRequiredInterface(ISensorManagerTag);
        return compSensors.getSensorsWith(feature);
    }

    @Override public synchronized boolean hasSensorsWith(String feature) {
        cosmapek.sensors.prov.ISensorManager compSensors =
            (cosmapek.sensors.prov.ISensorManager) this.manager.getRequiredInterface(ISensorManagerTag);
        return compSensors.hasSensorsWith(feature);
    }
}
