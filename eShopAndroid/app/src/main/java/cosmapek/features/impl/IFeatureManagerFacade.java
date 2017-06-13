package cosmapek.features.impl;

import cosmapek.features.core.FeatureM;
import cosmapek.features.core.FeatureMFactory;
import cosmapek.features.prov.IFeatureManager;
import cosmapek.features.prov.IManager;
import cosmapek.interfaces.IFeatureB;
import cosmapek.interfaces.IFeaturesB;

import java.util.LinkedList;

/**
 * Created by ArchyWin on 5/26/2015.
 */
class IFeatureManagerFacade implements IInterfaceTags, IFeatureManager {
    private IManager manager = null;
    private FeatureM features;

    public IFeatureManagerFacade(IManager manager) {
        this.manager = manager;
        this.features = FeatureMFactory.createInstance(this.manager);
    }

    @Override public synchronized void createAFeature(String name) {
        features.createAFeature(name);
    }

    @Override public synchronized void updateRuntimeRegistry(LinkedList<String> sol) {
        features.updateRuntimeRegistry(sol);
    }

    @Override public synchronized LinkedList<IFeatureB> getFeaturesWith(String feature) {
        return features.getFeaturesWith(feature);
    }

    @Override public synchronized boolean hasFeaturesWith(String feature) {
        return features.hasFeaturesWith(feature);
    }

    @Override public synchronized IFeaturesB getFeaturesInRuntime() {
        return features.getFeaturesInRuntime();
    }

    @Override public synchronized void clearFeatures() {
        features.clearFeatures();
    }

}
