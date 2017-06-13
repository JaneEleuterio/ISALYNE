package eShop.zCosmapek_Configurations;

import cosmapek.interfaces.IExecution;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: Catalogue
 * Component: Conn_Catalogue_Controller
 *
 * Manages the Conn_Catalogue_Controller configuration.
 */
public class Conn_Catalogue_Controller implements IExecution,IInterfaceTags {
    private catalogue.prov.IManager i_catalogue;
    private catalogue.prov.ICatalogueManager i_ICatalogueManager;

    private conn_Catalogue_Controller.prov.IManager i_conn_Catalogue_Controller;
    private controller.prov.IManager i_controller;

    @Override
    public synchronized void execute() {
        i_catalogue = catalogue.impl.ComponentFactory.createInstance();
        i_ICatalogueManager =
                (catalogue.prov.ICatalogueManager) i_catalogue.getProvidedInterface(ICatalogueManagerTag);

        i_conn_Catalogue_Controller= conn_Catalogue_Controller.impl.ComponentFactory.createInstance();
        i_conn_Catalogue_Controller.setRequiredInterface(ICatalogueManagerTag, i_ICatalogueManager);

        i_controller = controller.impl.ComponentFactory.createInstance();
        i_controller.setRequiredInterface(ICatalogueManagerTag,
                i_conn_Catalogue_Controller.getProvidedInterface(ICatalogueManagerTag));
    }
}