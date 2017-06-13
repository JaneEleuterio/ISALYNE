package cosmapek.conn_connectors_reader.impl;

import cosmapek.conn_connectors_reader.prov.IManager;

class Adapter implements cosmapek.reader.req.IConnectorManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override
    public synchronized void createAConnector(String name, String origin, String destination, int orderT) {
        cosmapek.connectors.prov.IConnectorManager compConnectors =
            (cosmapek.connectors.prov.IConnectorManager) this.manager
                .getRequiredInterface(IConnectorManagerTag);
        compConnectors.createAConnector(name, origin, destination, orderT);
    }

}
