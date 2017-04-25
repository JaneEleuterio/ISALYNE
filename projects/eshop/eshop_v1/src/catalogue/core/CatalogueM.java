package catalogue.core;

import java.util.ArrayList;

import utils.Produto;
import catalogue.prov.IManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: Catalogue
 * Component: Catalogue
 *
 * This class contains the concrete methods of component 'Catalogue'.
 */
public class CatalogueM {
    private IManager manager;

    
    public CatalogueM(IManager manager) {
        this.manager = manager;
    }

    private void getManagers() {
	
        
    }

	//TODO: Logic component methods
	//All business methods must follow the structure below, 
	//with synchronized and calling the method getManagers()
	
	//example of a business method
	/*
	public synchronized type businessMethod(param) {
	     getManagers();
			...
        return something;
    }
	*/
    public synchronized Produto buscaProduto(String nome){
    	getManagers();
    	ArrayList<Produto> produtos = new ArrayList<>();
    	Produto produtoA = new Produto(1,"Banana",10f,50,"Fruta");
    	produtos.add(produtoA);
    	Produto produtoB = new Produto(2,"Farofa",8f,50,"Farofa");
    	produtos.add(produtoB);
    	Produto produtoC = new Produto(3,"Macarrao",10f,50,"Miojo");
    	produtos.add(produtoC);
    	Produto produtoD = new Produto(4,"Carne",50f,50,"picanha");
    	produtos.add(produtoD);
    	Produto produtoE = new Produto(5,"Alface",5f,50,"Verdura");
    	produtos.add(produtoE);
    	Produto produtoF = new Produto(6,"Presunto",20f,50,"Carne Processada");
    	produtos.add(produtoF);
    	Produto produtoG = new Produto(7,"Queijo",15f,50,"Gorgonzola");
    	produtos.add(produtoG);
    	Produto produtoH = new Produto(8,"Vinho",100f,50,"Bebida Alcoolica");
    	produtos.add(produtoH);
    	
    	int i =0;
    	
    	for(i=0 ; i< produtos.size() ; i++){
    		if(produtos.get(i).getNome() == nome)
    			return produtos.get(i);
    	}
    	
 
    	return null;
    	
    }
}