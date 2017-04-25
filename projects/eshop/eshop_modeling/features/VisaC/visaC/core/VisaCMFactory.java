package visaC.core;

import visaC.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaC
 * Component: VisaC
 */
public class VisaCMFactory {
    private static VisaCM visaCM = null;

    public static synchronized VisaCM createInstance(IManager manager) {
        if (visaCM == null)
            visaCM = new VisaCM(manager);
        return visaCM;
    }
}