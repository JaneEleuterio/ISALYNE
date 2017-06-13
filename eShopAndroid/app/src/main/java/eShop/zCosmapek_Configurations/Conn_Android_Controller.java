package eShop.zCosmapek_Configurations;

import cosmapek.interfaces.IExecution;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: Android
 * Component: Conn_Android_Controller
 *
 * Manages the Conn_Android_Controller configuration.
 */
public class Conn_Android_Controller implements IExecution,IInterfaceTags {
    private android.prov.IManager i_android;
    private android.prov.IGUIManager i_IGUIManager;

    private conn_Android_Controller.prov.IManager i_conn_Android_Controller;
    private controller.prov.IManager i_controller;

    @Override
    public synchronized void execute() {
        i_android = android.impl.ComponentFactory.createInstance();
        i_IGUIManager =
                (android.prov.IGUIManager) i_android.getProvidedInterface(IGUIManagerTag);

        i_conn_Android_Controller= conn_Android_Controller.impl.ComponentFactory.createInstance();
        i_conn_Android_Controller.setRequiredInterface(IGUIManagerTag, i_IGUIManager);

        i_controller = controller.impl.ComponentFactory.createInstance();
        i_controller.setRequiredInterface(IGUIManagerTag,
                i_conn_Android_Controller.getProvidedInterface(IGUIManagerTag));
    }
}