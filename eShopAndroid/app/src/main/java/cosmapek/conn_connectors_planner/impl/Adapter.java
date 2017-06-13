package cosmapek.conn_connectors_planner.impl;

import cosmapek.conn_connectors_planner.prov.IManager;
import cosmapek.interfaces.IConnector;

import java.util.LinkedList;

class Adapter
    implements cosmapek.planner.req.IConnectorManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized LinkedList<IConnector> getConnectorsWith(String feature) {
        cosmapek.connectors.prov.IConnectorManager compConnector =
            (cosmapek.connectors.prov.IConnectorManager) this.manager
                .getRequiredInterface(IConnectorManagerTag);
        return compConnector.getConnectorsWith(feature);
    }

    @Override public synchronized boolean hasConnectorsWith(String feature) {
        cosmapek.connectors.prov.IConnectorManager compConnector =
            (cosmapek.connectors.prov.IConnectorManager) this.manager
                .getRequiredInterface(IConnectorManagerTag);
        return compConnector.hasConnectorsWith(feature);
    }
}
