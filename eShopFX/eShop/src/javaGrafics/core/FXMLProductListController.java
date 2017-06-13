/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaGrafics.core;

import utils.Cart;
import utils.Information;
import utils.Produto;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.prov.IControllerManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author avatar
 */
public class FXMLProductListController implements Initializable {
	
	///////////FXML variáveis///////////////////////
	
    @FXML
    private TableView<Produto> item;
    
    @FXML
    private TableColumn<Produto, String> product;
    
    @FXML
	private Label resultSearch;
	
    @FXML
    private Label name;
    
    @FXML
    private Label value;
    
    @FXML
    private Label amount;
    
    @FXML
    private Label description;
    
    /////////////////////////////////////////////////

    
    ////////////////Variável do controller///////////////////////////
	private controller.prov.IControllerManager i_IControllerManager;
	////////////////////////////////////////////////////////////////
	
    /**
     * 
     * Volta para a cena de início.
     * 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void buttonBackAction(ActionEvent event) throws IOException {
        Parent StartApp_page_parent = FXMLLoader.load(getClass().getResource("FXMLStartApp.fxml"));
        
        Scene StartApp_page_scene = new Scene(StartApp_page_parent);
        
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        app_stage.hide();
        app_stage.setTitle("Procurar por produto");
        app_stage.setScene(StartApp_page_scene);
        app_stage.show();
    }
    
    /**
     * 
     * Método que mostra uma janela de confirmação e volta para a tela de início.
     * 
     * @param event
     * @throws IOException 
     */
    private void messageAddToCart(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Adicionando produto ao carrinho");
        alert.setHeaderText("O produto foi adicionado ao carrinho com sucesso!");

        ButtonType buttonTypeOne = new ButtonType("OK");

        alert.getButtonTypes().setAll(buttonTypeOne);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
            buttonBackAction(event);
        }
    }
    
    /**
     * 
     * Método que mostra uma janela perguntando se 
     * realmente quer adicionar o produto ao carrinho.
     * 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void buttonAddToCartAction(ActionEvent event) throws IOException {
        
    	Produto selectedProduct = item.getSelectionModel().getSelectedItem();
    	
    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Adicionando produto ao carrinho");
        alert.setHeaderText("Gostaria de adicionar este produto ao carrinho?");
       
        ButtonType buttonTypeOne = new ButtonType("Sim", ButtonBar.ButtonData.YES);
        ButtonType buttonTypeTwo = new ButtonType("Não", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
        	Produto product = new Produto(selectedProduct.getId(), selectedProduct.getName(), selectedProduct.getValue(), 1, selectedProduct.getDescription());
        	int cart = Cart.addToCart(product);
        	if (cart == 1) {
        		messageAddToCart(event);	
        	}
        }
    }
    
    /**
     * 
     * Método que preenche os atributos de Item, caso Item seja vazio, preenche com "".
     * 
     * @param item Objeto da classe Item.
     */
    private void itemDetails(Produto item) {
        if (item != null) {
            name.setText(item.getName());
            value.setText(String.valueOf(item.getValue()));
            amount.setText(String.valueOf(item.getAmount()));
            description.setText(item.getDescription());
        } else {
            name.setText("");
            value.setText("");
            amount.setText("");
            description.setText("");
        }
    }
    
    /**
     * Método que inicia o controller
     * @return i_IControllerManager
     */
    private IControllerManager initController() {
    	controller.prov.IControllerManager i_IControllerManager;
    	controller.prov.IManager comp_Controller;
    	comp_Controller = controller.impl.ComponentFactory.createInstance();
    	String IControllerManagerTag = "IControllerManager";
    	
    	i_IControllerManager = (controller.prov.IControllerManager) comp_Controller.getProvidedInterface(IControllerManagerTag);
    	
    	return i_IControllerManager;
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    	resultSearch.setText(Information.getTextInfo());
    	
    	i_IControllerManager = initController();
    	
        ObservableList<Produto> itemList = FXCollections.observableArrayList();
        
        if (Information.getTextInfo().isEmpty()) {
        	itemList = i_IControllerManager.searchAllProducts();
        } else {
        	itemList.add(i_IControllerManager.buscaProdutoController(Information.getTextInfo()));	
        }
        
        product.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
         
        itemDetails(null);

        item.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> itemDetails(newValue));
         
        item.setItems(itemList);
    }      
    
}
