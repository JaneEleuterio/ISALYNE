/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaGrafics.core;

import utils.Cart;
import utils.Produto;
import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author avatar
 */
public class FXMLCartFreightController implements Initializable {

	///////////FXML variáveis///////////////////////////////
	
    @FXML
    private TableView<Produto> item;
    
    @FXML
    private TableColumn<Produto, String> product;
    
    @FXML
    private TextField amount;
    
    @FXML
    private Label name;
    
    @FXML
    private Label value;
    
    @FXML
    private Label total;
    
    @FXML
    private Label freight;
    
    ///////////////////////////////////////////////////////
    
    
    
    /**
     * 
     * Abre a cena formas de pagamento.
     * 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void buttonPaymentPage(ActionEvent event) throws IOException {
    	
    	Cart.setFreight(1);
    	
        Parent Payment_page_parent = FXMLLoader.load(getClass().getResource("FXMLPayment.fxml"));
        
        Scene Payment_page_scene = new Scene(Payment_page_parent);
        
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        app_stage.hide();
        app_stage.setTitle("Formas de pagamento");
        app_stage.setScene(Payment_page_scene);
        app_stage.show();
    }
    
    /**
     * Volta para a cena inicial
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
     * Método que preenche os atributos de Item, caso Item seja vazio, preenche com "".
     * 
     * @param item Objeto da classe Item.
     */
    private void itemDetails(Produto item) {
        if (item != null) {
            name.setText(item.getName());
            value.setText(String.valueOf(item.getValue()));
            amount.setText(String.valueOf(item.getAmount()));
        } else {
            name.setText("");
            value.setText("");
            amount.setText("");
        }
    }
    
    /**
     * Método que remove o item do carrinho de compras e atualiza o valor total da compra.
     */
    @FXML
    private void buttonDeleteItemFromCartAction() {
        int selectedIndex = item.getSelectionModel().getSelectedIndex();
        
        if (selectedIndex >= 0) {
            item.getItems().remove(selectedIndex);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	        alert.setTitle("Remoção bem sucedida");
	        alert.setHeaderText("Produto removido com sucesso!");

	        ButtonType buttonTypeOne = new ButtonType("OK");

	        alert.getButtonTypes().setAll(buttonTypeOne);
	        alert.showAndWait();
            String totalResult = String.valueOf(NumberFormat.getCurrencyInstance().format(Cart.getTotalAmount())) + " R$";
	        total.setText(totalResult);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Nenhuma seleção");
            alert.setHeaderText("Nenhum produto selecionado!");
            alert.setContentText("Por favor, selecione um produto.");
            alert.showAndWait();
        }
    }
    
    /**
     * Método que atualiza o valor total da compra, 
     * de acordo com a quantidade de itens selecionados.
     */
    @FXML
    private void buttonUpdateProductOnCart() {
    	if (amount.getText().matches("[1-9]")) {
    		Produto selectedProduct = item.getSelectionModel().getSelectedItem();
    		selectedProduct.setAmount(Integer.parseInt(amount.getText()));
    		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	        alert.setTitle("Alteração bem sucedida");
	        alert.setHeaderText("Quantidade alterada com sucesso!");

	        ButtonType buttonTypeOne = new ButtonType("OK");

	        alert.getButtonTypes().setAll(buttonTypeOne);
	        alert.showAndWait();
	        String totalResult = String.valueOf(NumberFormat.getCurrencyInstance().format(Cart.getTotalAmount())) + " R$";
	        total.setText(totalResult);
    	}  else {
    		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	        alert.setTitle("Número inválido");
	        alert.setHeaderText("Por favor, informe um número entre 1 e 9");

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
        ObservableList<Produto> itemList = Cart.getAllFromCart();

        String totalResult = String.valueOf(NumberFormat.getCurrencyInstance().format(Cart.getTotalAmount())) + " R$";
      
        total.setText(totalResult);
        
        freight.setText("20,00 R$");


        product.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        itemDetails(null);

        item.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> itemDetails(newValue));

        item.setItems(itemList);
    }     
    
}
