package masterCardA.core;

import masterCardA.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardA
 * Component: MasterCardA
 */
public class MasterCardAMFactory {
    private static MasterCardAM masterCardAM = null;

    public static synchronized MasterCardAM createInstance(IManager manager) {
        if (masterCardAM == null)
            masterCardAM = new MasterCardAM(manager);
        return masterCardAM;
    }
}