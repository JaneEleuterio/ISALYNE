package conn_Catalogue_Controller.impl;

import utils.Produto;
import conn_Catalogue_Controller.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: Catalogue
 * Component: Conn_Catalogue_Controller
 */
class Adapter
    implements controller.req.ICatalogueManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

	//TODO: Adaptation of business methods
	//This class connects the business methods of the 
	//required interface 'controller.req.ICatalogueManager' 
	//with business methods from the provided interface
	//'catalogue.prov.ICatalogueManager'	
	
	//example of a business method
	/*
	@Override
    public synchronized type businessMethod(param){
        catalogue.prov.ICatalogueManager comp_catalogue =
                (catalogue.prov.ICatalogueManager) this.manager.getRequiredInterface(ICatalogueManagerTag);
        return comp_catalogue.businessMethod(param);
    }
	*/
	public synchronized Produto buscaProduto(String nome){
		catalogue.prov.ICatalogueManager comp_catalogue =
                (catalogue.prov.ICatalogueManager) this.manager.getRequiredInterface(ICatalogueManagerTag);
        return comp_catalogue.buscaProduto(nome);
	}
    
}