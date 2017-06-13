package cosmapek.conn_features_reader.impl;

import cosmapek.conn_features_reader.prov.IManager;

class Adapter implements cosmapek.reader.req.IFeatureManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized void createAFeature(String name) {
        cosmapek.features.prov.IFeatureManager compFeatures =
            (cosmapek.features.prov.IFeatureManager) this.manager.getRequiredInterface(IFeatureManagerTag);
        compFeatures.createAFeature(name);
    }
}
