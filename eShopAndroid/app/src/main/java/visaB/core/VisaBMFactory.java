package visaB.core;

import visaB.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaB
 * Component: VisaB
 */
public class VisaBMFactory {
    private static VisaBM visaBM = null;

    public static synchronized VisaBM createInstance(IManager manager) {
        if (visaBM == null)
            visaBM = new VisaBM(manager);
        return visaBM;
    }
}