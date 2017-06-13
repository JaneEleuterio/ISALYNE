package cosmapek.conn_sensors_analyzer.impl;

import cosmapek.conn_sensors_analyzer.prov.IManager;
import cosmapek.interfaces.ISensors;

class Adapter implements cosmapek.analyzer.req.ISensorManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized boolean hasSensorsInRuntime() {
        cosmapek.sensors.prov.ISensorManager compSensors =
            (cosmapek.sensors.prov.ISensorManager) this.manager.getRequiredInterface(ISensorManagerTag);

        return compSensors.hasSensorsInRuntime();
    }

    @Override
    public ISensors getSensors() {
        cosmapek.sensors.prov.ISensorManager compSensors =
                (cosmapek.sensors.prov.ISensorManager) this.manager.getRequiredInterface(ISensorManagerTag);

        return compSensors.getSensors();
    }

    @Override public synchronized ISensors getSensorsInRuntime() {
        cosmapek.sensors.prov.ISensorManager compSensors =
            (cosmapek.sensors.prov.ISensorManager) this.manager.getRequiredInterface(ISensorManagerTag);

        return compSensors.getSensorsInRuntime();
    }
}
