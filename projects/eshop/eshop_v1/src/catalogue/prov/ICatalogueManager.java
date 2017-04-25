package catalogue.prov;

import utils.Produto;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: Catalogue
 * Component: Catalogue
 * 
 * This 'ICatalogueManager' interface is provided by the component 'Catalogue'. All 
 * signatures to business methods present here should be updated on the components that 
 * have this 'ICatalogueManager' interface as required.
 */
public interface ICatalogueManager {
	
	public Produto buscaProduto(String nome);

    //TODO: Signatures of business methods

	//This interface must be equivalent to the 
	//required interfaces in client components
}