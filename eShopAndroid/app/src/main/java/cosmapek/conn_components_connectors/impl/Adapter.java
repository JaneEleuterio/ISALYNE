package cosmapek.conn_components_connectors.impl;

import cosmapek.conn_components_connectors.prov.IManager;
import cosmapek.interfaces.IComponent;

import java.util.LinkedList;

class Adapter
    implements cosmapek.connectors.req.IComponentManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized LinkedList<IComponent> getComponentsWith(String feature) {
        cosmapek.components.prov.IComponentManager compComponents =
            (cosmapek.components.prov.IComponentManager) this.manager
                .getRequiredInterface(IComponentManagerTag);
        return compComponents.getComponentsWith(feature);
    }

    @Override public synchronized boolean hasComponentsWith(String feature) {
        cosmapek.components.prov.IComponentManager compComponents =
            (cosmapek.components.prov.IComponentManager) this.manager
                .getRequiredInterface(IComponentManagerTag);
        return compComponents.hasComponentsWith(feature);
    }
}
