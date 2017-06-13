package utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Classe que guarda informações referentes ao carrinho de compra.
 * @author Avatar
 *
 */
public class Cart {
	
	private static ObservableList<Produto> cart = FXCollections.observableArrayList();
	
	private static int freight;
	
	public static void freightInitialize(){
		freight = 0;
	}
	
	public static void setFreight(int flagFreight) {
		freight = flagFreight;
	}
	
	public static int getFreight() {
		return freight;
	}
	
	public static void cartInitialize() {
		cart.clear();
	}
	
	public static int hasItens() {
		if (!cart.isEmpty())
			return 1;
		return 0;
	}
	
	public static int addToCart(Produto product) {
		try {
			cart.add(product);
			return 1;
		} catch(Exception e) {
			return 0;
		}
	}
	
	public static int removeFromCart(int id) {
		try {
			for(int i = 0 ; i < cart.size() ; i++){
	    		if(cart.get(i).getId() == id) {
	    			cart.remove(i);
	    			return 1;
	    		}
	    	}	
			return 0;
		} catch(Exception e) {
			return 0;
		}
	}
	
	public static ObservableList<Produto> getAllFromCart() {
		return cart;
	}
	
	public static float getTotalAmount() {
		float result = 0.0f;
		for(int i = 0 ; i < cart.size() ; i++){
			result = result + cart.get(i).getAmount()*cart.get(i).getValue();
		}
    	return result;
	}
	
	public static float getTotalAmountFreight() {
		float result = 0.0f;
		for(int i = 0 ; i < cart.size() ; i++){
			result = result + cart.get(i).getAmount()*cart.get(i).getValue();
		}
		result = result + 20.0f;
    	return result;
	}
	
	public static void printCurrentItens() {
		for(int i = 0 ; i < cart.size() ; i++){
			System.err.println(cart.get(i).getName());
		}
	}
	
}
