package android.core;

import android.core.*;
import android.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: Android
 * Component: Android
 */
public class AndroidMFactory {
    private static android.core.AndroidM androidM = null;

    public static synchronized android.core.AndroidM createInstance(IManager manager) {
        if (androidM == null)
            androidM = new android.core.AndroidM(manager);
        return androidM;
    }
}