package catalogue.core;

import catalogue.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: Catalogue
 * Component: Catalogue
 */
public class CatalogueMFactory {
    private static CatalogueM catalogueM = null;

    public static synchronized CatalogueM createInstance(IManager manager) {
        if (catalogueM == null)
            catalogueM = new CatalogueM(manager);
        return catalogueM;
    }
}