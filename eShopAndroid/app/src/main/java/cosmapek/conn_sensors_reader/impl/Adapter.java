package cosmapek.conn_sensors_reader.impl;

import cosmapek.conn_sensors_reader.prov.IManager;

class Adapter implements cosmapek.reader.req.ISensorManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized void createASensor(String name, String feature, boolean isSensor, int orderT) {
        cosmapek.sensors.prov.ISensorManager compSensors =
            (cosmapek.sensors.prov.ISensorManager) this.manager.getRequiredInterface(ISensorManagerTag);
        compSensors.createASensor(name, feature, isSensor, orderT);
    }
}
