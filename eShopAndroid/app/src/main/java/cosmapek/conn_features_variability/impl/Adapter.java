package cosmapek.conn_features_variability.impl;

import cosmapek.conn_features_variability.prov.IManager;

import java.util.LinkedList;

class Adapter
    implements cosmapek.variability.req.IFeatureManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized void updateRuntimeRegistry(LinkedList<String> sol) {
        cosmapek.features.prov.IFeatureManager compFeatures =
            (cosmapek.features.prov.IFeatureManager) this.manager.getRequiredInterface(IFeatureManagerTag);
        compFeatures.updateRuntimeRegistry(sol);
    }
}
