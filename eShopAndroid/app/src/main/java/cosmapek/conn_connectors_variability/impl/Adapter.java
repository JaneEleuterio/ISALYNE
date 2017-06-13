package cosmapek.conn_connectors_variability.impl;

import cosmapek.conn_connectors_variability.prov.IManager;

import java.util.LinkedList;

class Adapter
    implements cosmapek.variability.req.IConnectorManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized void updateRuntimeRegistry(LinkedList<String> sol) {
        cosmapek.connectors.prov.IConnectorManager compConnectors =
            (cosmapek.connectors.prov.IConnectorManager) this.manager
                .getRequiredInterface(IConnectorManagerTag);
        compConnectors.updateRuntimeRegistry(sol);
    }
}
