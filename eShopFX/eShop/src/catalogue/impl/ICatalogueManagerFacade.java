package catalogue.impl;

import utils.Produto;
import catalogue.core.CatalogueM;
import catalogue.core.CatalogueMFactory;
import catalogue.prov.IManager;
import javafx.collections.ObservableList;
import catalogue.prov.ICatalogueManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: Catalogue
 * Component: Catalogue
 */
class ICatalogueManagerFacade implements IInterfaceTags, ICatalogueManager {


    private IManager manager = null;
    private CatalogueM catalogueM;

    ICatalogueManagerFacade(IManager manager) {
        this.manager = manager;
        this.catalogueM = CatalogueMFactory.createInstance(this.manager);
    }

    //TODO: Each business method from the interface 'ICatalogueManager'
	//must be implemented here by invoking its method in the concrete 
	//component  Catalogue and with 'synchronized' notation
	
	//example of a business method 
	/*
	public synchronized type businessMethod(param) {
        return  catalogueM.businessMethod(param);
    }
	*/
    public synchronized Produto buscaProduto(String nome){
    	return catalogueM.buscaProduto(nome);
    }
    
    public synchronized ObservableList<Produto> searchAllProducts(){
    	return catalogueM.searchAllProducts();
    }
}