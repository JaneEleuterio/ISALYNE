package controller.req;

import utils.Produto;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: App
 * Component: Controller
 * 
 * This interface is required by the 'Controller' component (Controller.req.ICatalogueManager). 
 * All signatures of business methods present here must be present in the 'ICatalogueManager' interface 
 * on the component origin (Catalogue.prov.ICatalogueManager).
 */
public interface ICatalogueManager {
	public Produto buscaProduto(String nome);

	//TODO: Signatures of business methods

	//This interface must be equivalent to the interface provided on 
	//the provider component (Catalogue.prov.ICatalogueManager)

}