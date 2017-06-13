package cosmapek.conn_components_variability.impl;

import cosmapek.conn_components_variability.prov.IManager;

import java.util.LinkedList;

class Adapter
    implements cosmapek.variability.req.IComponentManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized void updateRuntimeRegistry(LinkedList<String> sol) {
        cosmapek.components.prov.IComponentManager compComponents =
            (cosmapek.components.prov.IComponentManager) this.manager
                .getRequiredInterface(IComponentManagerTag);
        compComponents.updateRuntimeRegistry(sol);//error
    }
}
