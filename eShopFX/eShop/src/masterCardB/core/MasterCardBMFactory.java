package masterCardB.core;

import masterCardB.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardB
 * Component: MasterCardB
 */
public class MasterCardBMFactory {
    private static MasterCardBM masterCardBM = null;

    public static synchronized MasterCardBM createInstance(IManager manager) {
        if (masterCardBM == null)
            masterCardBM = new MasterCardBM(manager);
        return masterCardBM;
    }
}