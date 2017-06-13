package cosmapek.conn_components_reader.impl;

import cosmapek.conn_components_reader.prov.IManager;

class Adapter implements cosmapek.reader.req.IComponentManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override
    public synchronized void createAComponent(String name, String feature, boolean isSensor, int orderT) {
        cosmapek.components.prov.IComponentManager compComponents =
            (cosmapek.components.prov.IComponentManager) this.manager
                .getRequiredInterface(IComponentManagerTag);
        compComponents.createAComponent(name, feature, isSensor, orderT);
    }
}
