/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaGrafics.core;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.Cart;
import utils.Information;

/**
 * FXML Controller class
 *
 * @author avatar
 */
public class FXMLStartAppController implements Initializable {
	
	///////////FXML variáveis////////
	
	@FXML
    private TextField searchBox;
	
	/////////////////////////////////
	
    /**
     * Abre a cena de lista de produtos.
     * 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void buttonSearchAction(ActionEvent event) throws IOException {
    	
    	Information.setTextInfo(searchBox.getText());
    	
        Parent ProductList_page_parent = FXMLLoader.load(getClass().getResource("FXMLProductList.fxml"));
        
        Scene ProductList_page_scene = new Scene(ProductList_page_parent);
        
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        app_stage.hide();
        app_stage.setTitle("Lista de opções");
        app_stage.setScene(ProductList_page_scene);
        app_stage.show();
    }
    
    /**
     * Abre a cena de carrinho de compras.
     * 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void buttonCartAction(ActionEvent event) throws IOException {
    	
    	int cartItens = Cart.hasItens();
    	
    	if (cartItens == 1) {
    		Parent Cart_page_parent = FXMLLoader.load(getClass().getResource("FXMLCart.fxml"));
            
            Scene Cart_page_scene = new Scene(Cart_page_parent);
            
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            app_stage.hide();
            app_stage.setTitle("Carrinho de compras");
            app_stage.setScene(Cart_page_scene);
            app_stage.show();	
    	} else {
    		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	        alert.setTitle("Carrinho Vazio");
	        alert.setHeaderText("Adicione algum produto ao carrinho!");

	        ButtonType buttonTypeOne = new ButtonType("OK");

	        alert.getButtonTypes().setAll(buttonTypeOne);
	        alert.showAndWait();

    	}
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
