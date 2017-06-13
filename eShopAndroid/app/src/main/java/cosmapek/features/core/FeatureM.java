package cosmapek.features.core;

import cosmapek.features.prov.IManager;
import cosmapek.interfaces.IFeatureB;
import cosmapek.interfaces.IFeaturesB;

import java.util.LinkedList;

/**
 * Created by ArchyWin on 6/3/2015.
 */
public class FeatureM {
    IManager manager;
    private IFeaturesB features; //set of cosmapek.sensors ( runtime and not runtime)
    private IFeaturesB featuresinRuntime; //set of cosmapek.sensors

    public FeatureM(IManager manager) {
        this.manager = manager;
        this.features = new Features();
        this.featuresinRuntime = new Features();
    }

    public void createAFeature(String name) {
        features.add(new Feature(name));
    }

    public synchronized LinkedList<IFeatureB> getFeaturesWith(String feature) {
        LinkedList<IFeatureB> resp = new LinkedList<IFeatureB>();
        for (IFeatureB s : features) {
            if (s.getFeatureName().equals(feature)) {
                resp.add(s);
            }
        }
        return resp;
    }

    public synchronized void updateRuntimeRegistry(LinkedList<String> sol) {
        featuresinRuntime.clear();
        for (String s : sol) {
            for (IFeatureB fea : getFeaturesWith(s)) {
                featuresinRuntime.add(fea);
            }
        }
    }

    public synchronized void clearFeatures() {
        featuresinRuntime.clear();
        features.clear();
    }

    public synchronized IFeaturesB getFeaturesInRuntime() {
        return featuresinRuntime;
    }

    public synchronized boolean hasFeaturesWith(String feature) {
        if (getFeaturesWith(feature).size() == 0) {
            return false;
        }
        return true;
    }
}
