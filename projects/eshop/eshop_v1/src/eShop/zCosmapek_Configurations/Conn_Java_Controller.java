package eShop.zCosmapek_Configurations;

import cosmapek.interfaces.IExecution;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: Java
 * Component: Conn_Java_Controller
 *
 * Manages the Conn_Java_Controller configuration.
 */
public class Conn_Java_Controller implements IExecution,IInterfaceTags {
    private javaGrafics.prov.IManager i_java;
    private javaGrafics.prov.IGUIManager i_IGUIManager;

    private conn_Java_Controller.prov.IManager i_conn_Java_Controller;
    private controller.prov.IManager i_controller;

    @Override
    public synchronized void execute() {
        i_java = javaGrafics.impl.ComponentFactory.createInstance();
        i_IGUIManager =
                (javaGrafics.prov.IGUIManager) i_java.getProvidedInterface(IGUIManagerTag);

        i_conn_Java_Controller= conn_Java_Controller.impl.ComponentFactory.createInstance();
        i_conn_Java_Controller.setRequiredInterface(IGUIManagerTag, i_IGUIManager);

        i_controller = controller.impl.ComponentFactory.createInstance();
        i_controller.setRequiredInterface(IGUIManagerTag,
                i_conn_Java_Controller.getProvidedInterface(IGUIManagerTag));
    }
}