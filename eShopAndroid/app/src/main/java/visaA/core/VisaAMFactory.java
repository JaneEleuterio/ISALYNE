package visaA.core;

import visaA.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaA
 * Component: VisaA
 */
public class VisaAMFactory {
    private static VisaAM visaAM = null;

    public static synchronized VisaAM createInstance(IManager manager) {
        if (visaAM == null)
            visaAM = new VisaAM(manager);
        return visaAM;
    }
}