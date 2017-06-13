package catalogue.core;

import utils.Produto;
import catalogue.prov.IManager;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;


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
    
    /**
     * M�todo que busca produto pelo nome
     * @param nome String
     * @return Produto caso encontre, null caso contr�rio.
     */
    public synchronized Produto buscaProduto(String nome){
    	getManagers();
    	
    	/*ObservableList<Produto> list = FXCollections.observableArrayList();
    	
    	Produto produtoA = new Produto(1,"Banana",10f,50,"Fruta");
    	list.add(produtoA);
    	Produto produtoB = new Produto(2,"Farofa",8f,50,"Farofa");
    	list.add(produtoB);
    	Produto produtoC = new Produto(3,"Macarrao",10f,50,"Miojo");
    	list.add(produtoC);
    	Produto produtoD = new Produto(4,"Carne",50f,50,"picanha");
    	list.add(produtoD);
    	Produto produtoE = new Produto(5,"Alface",5f,50,"Verdura");
    	list.add(produtoE);
    	Produto produtoF = new Produto(6,"Presunto",20f,50,"Carne Processada");
    	list.add(produtoF);
    	Produto produtoG = new Produto(7,"Queijo",15f,50,"Gorgonzola");
    	list.add(produtoG);
    	Produto produtoH = new Produto(8,"Vinho",100f,50,"Bebida Alcoolica");
    	list.add(produtoH);
    	
    	int i =0;
    	
    	for(i=0 ; i< list.size() ; i++){
    		if(list.get(i).getName().equals(nome))
    			return list.get(i);
    	}*/
    	
    	return null;
    	
    }
    
    /**
     * M�todo que que busca todos os produtos
     * @return ObservableList<Produto>; Lista com todos os produtos do cat�logo.
     */
    /*public synchronized ObservableList<Produto> searchAllProducts(){
    	getManagers();
    	
    	ObservableList<Produto> list = FXCollections.observableArrayList();
    	
    	Produto produtoA = new Produto(1,"Banana",10f,50,"Fruta");
    	list.add(produtoA);
    	Produto produtoB = new Produto(2,"Farofa",8f,50,"Farofa");
    	list.add(produtoB);
    	Produto produtoC = new Produto(3,"Macarrao",10f,50,"Miojo");
    	list.add(produtoC);
    	Produto produtoD = new Produto(4,"Carne",50f,50,"picanha");
    	list.add(produtoD);
    	Produto produtoE = new Produto(5,"Alface",5f,50,"Verdura");
    	list.add(produtoE);
    	Produto produtoF = new Produto(6,"Presunto",20f,50,"Carne Processada");
    	list.add(produtoF);
    	Produto produtoG = new Produto(7,"Queijo",15f,50,"Gorgonzola");
    	list.add(produtoG);
    	Produto produtoH = new Produto(8,"Vinho",100f,50,"Bebida Alcoolica");
    	list.add(produtoH);
    	
    	return list;
    	
    }*/
}