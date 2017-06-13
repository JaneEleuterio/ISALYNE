/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaGrafics.core;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import utils.Cart;
import utils.Information;

/**
 * FXML Controller class
 *
 * @author avatar
 */
public class FXMLBuyMessageController implements Initializable {

	///////////FXML variáveis/////////////
    @FXML
    private Label code;
    
    @FXML
    private Label btn_label;
    //////////////////////////////////////
    
    private int id;
    
    /**
     * 
     * Abre a cena procurar produtos.
     * 
     * @param event
     * @throws IOException 
     */
    private void backToStart(ActionEvent event) throws IOException {
        Parent StartApp_page_parent = FXMLLoader.load(getClass().getResource("FXMLStartApp.fxml"));
        
        Scene StartApp_page_scene = new Scene(StartApp_page_parent);
        
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        app_stage.hide();        
        app_stage.setTitle("Buscar por produtos");
        app_stage.setScene(StartApp_page_scene);
        app_stage.show();
    }
    
    /**
     * Abre a cena formas de pagamento.
     * @param event
     * @throws IOException
     */
    private void backToPayment(ActionEvent event) throws IOException {
    	Parent Payment_page_parent = FXMLLoader.load(getClass().getResource("FXMLPayment.fxml"));
        
        Scene Payment_page_scene = new Scene(Payment_page_parent);
        
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        app_stage.hide();
        app_stage.setTitle("Formas de pagamento");
        app_stage.setScene(Payment_page_scene);
        app_stage.show();
    }
    
    /**
     * Chama o método de acordo com o id da mensagem.
     * @param event
     * @throws IOException
     */
    @FXML
    private void buttonCallByID(ActionEvent event) throws IOException {
    	if (id == 1) {
    		backToStart(event);
    	} else {
    		backToPayment(event);
    	}
    }
    
    /**
     * Método que dado um id, retorna sua mensagem correspondente.
     * @param id String, id da mensagem
     * @return String msg
     */
    private String getMessageById(int id) {
    	String msg;
    	
    	switch(id) {
    		
    	case 1:
    		msg = "      Compra realizada    ";
    		Cart.cartInitialize();
    		break;
    		
    	case 2:
    		msg = "    Erro ao buscar cartão ";
    		break;
    		
    	case 3:
    		msg = "       Cartão inválido    ";
    		break;
    		
    	case 4:
    		msg = "  Erro ao consultar saldo ";
    		break;
    		
    	case 5:
    		msg = "      Limite excedido!     ";
    		break;
    		
    	case 6:
    		msg = "Erro ao registrar a compra";
    		break;
    		
		default:
			msg = "";
			break;
    	
    	}
    	
    	return msg;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	id = Integer.parseInt(Information.getMsg().substring(Information.getMsg().length() -2, Information.getMsg().length() -1));
    	if (id == 1) {
    		btn_label.setText("Inicio");
    	} else {
    		btn_label.setText("Tentar novamente");
    	}
    	code.setText(getMessageById(id));
    }    
    
}
