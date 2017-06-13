package javaGrafics.core;

import javaGrafics.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: Java
 * Component: Java
 */
public class JavaMFactory {
    private static JavaM javaM = null;

    public static synchronized JavaM createInstance(IManager manager) {
        if (javaM == null)
            javaM = new JavaM(manager);
        return javaM;
    }
}