package conn_sensors_VisaASensor.impl;

import conn_sensors_VisaASensor.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaA
 * Component: Conn_sensors_VisaASensor
 */
public class ComponentFactory {
    private static IManager manager = null;

    private ComponentFactory() {
    }

    public static synchronized IManager createInstance() {
        if (manager == null)
            manager = new Manager();
        return manager;
    }
}