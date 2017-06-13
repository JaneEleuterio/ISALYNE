/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaGrafics.core;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import controller.prov.IControllerManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import utils.BankTransfer;
import utils.Cart;
import utils.Information;

/**
 * FXML Controller class
 *
 * @author avatar
 */
public class FXMLPaymentController implements Initializable {
	
	///////////FXML variáveis//////////////////////////////////
	@FXML
	private ToggleGroup card_type;
	
	@FXML
	private RadioButton card_type_v;
	
	@FXML
	private RadioButton card_type_m;
	
	@FXML
    private ComboBox month;
    
    @FXML
    private ComboBox year;
    
    @FXML
    private ComboBox portion;
    
    @FXML
    private TextField fieldGhob;
    
    @FXML
    private TextField name;
    
    @FXML
    private TextField number;
    
    @FXML
    private TextField code;
	
	@FXML
	private Label bt_bank;
	
	@FXML
	private Label bt_name;
	
	@FXML
	private Label bt_number;
	
	@FXML
	private Label bt_agency;
	
	@FXML
	private Label bt_cpf;
	
    @FXML
    private Label ghob;
    
    @FXML
    private Label show_total_creditCard;
    
    @FXML
    private Label show_total_bankInvoice;
    
    @FXML
    private Label show_total_bankTransfer;
    
    @FXML
    private Label show_total_money;
    
    ///////////////////////////////////////////////////////////
    
    private float total_money;
    
    private float total_creditCard;
    
    private float total_bankInvoice;
    
    private float total_bankTransfer;
    
    private String validation_date;
    
    ////////////////Variável do controller///////////////////////////
    private controller.prov.IControllerManager i_IControllerManager;
    ////////////////////////////////////////////////////////////////
    
    /**
     * 
     * Método que verifica se os campos do cartão de crédito não estão vazios, 
     * caso estejam, mostra um alerta, caso contrário, realiza o pagamento.
     * 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void buttonPayCreditAction(ActionEvent event) throws IOException {
        if (name.getText().isEmpty() || number.getText().isEmpty() || code.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Nenhuma seleção");
            alert.setHeaderText("Nenhum valor informado!");
            alert.setContentText("Por favor, preencha novamente os campos do cartão de crédito.");
            alert.showAndWait();
        } else {
        	if (number.getText().matches("[0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4}")) {
        		if (code.getText().matches("[0-9]{3}")) {
        			if (month.getSelectionModel().getSelectedItem().equals("Mês")) {
        				Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Selecione o  mês!");
                        alert.setHeaderText("Selecione o mês");
                        alert.setContentText("Por favor, selecione o mês da validade do cartão de crédito");
                        alert.showAndWait();
        			} else {
        				if (year.getSelectionModel().getSelectedItem().equals("Ano")) {
        					Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Selecione o ano!");
                            alert.setHeaderText("Selecione o ano");
                            alert.setContentText("Por favor, selecioneo ano da validade do cartão de crédito");
                            alert.showAndWait();
        				} else {
        			    	if (month.getSelectionModel().getSelectedIndex() + 1 < 10) {
        			    		validation_date = "0" + String.valueOf(month.getSelectionModel().getSelectedIndex() + 1)+"/"+String.valueOf(year.getSelectionModel().getSelectedItem()).substring(2, 4);
        					} else {
        						validation_date = String.valueOf(month.getSelectionModel().getSelectedIndex()  + 1)+"/"+String.valueOf(year.getSelectionModel().getSelectedItem()).substring(2, 4);;
        					}
        			    	
        					Information.setMsg(i_IControllerManager.pagarComCartaoDeCreditoController(Integer.parseInt(String.valueOf(Information.getCardType())), total_creditCard, String.valueOf(name.getText()), String.valueOf(number.getText()), validation_date, String.valueOf(code.getText()), Integer.parseInt(String.valueOf(portion.getSelectionModel().getSelectedItem()))));
        			    	
        					Parent BuyMessage_page_parent = FXMLLoader.load(getClass().getResource("FXMLBuyMessage.fxml"));
                            
                            Scene BuyMessage_page_scene = new Scene(BuyMessage_page_parent);
                            
                            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                            app_stage.hide();
                            app_stage.setTitle("Mensagem da compra");
                            app_stage.setScene(BuyMessage_page_scene);
                            app_stage.show();	

        				}        				        			
    				}
        		} else {
        			Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Código inválido!");
                    alert.setHeaderText("Código de cartão de crédito inválido!");
                    alert.setContentText("Por favor, informe novamente o código do cartão de crédito");
                    alert.showAndWait();
        		}
        	} else {
        		Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Número inválido!");
                alert.setHeaderText("Número de cartão de crédito inválido!");
                alert.setContentText("Por favor, informe novamente o número do cartão de crédito");
                alert.showAndWait();
        	}
        }
    }
    
    /**
     * 
     * Método que verifica se tem troco, caso tenha, mostra o troco calculado,
     * caso contrário, mostra uma mensagem de alerta.
     * 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void showGhob(ActionEvent event) throws IOException {
        if (fieldGhob.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Nenhuma seleção");
            alert.setHeaderText("Nenhum valor informado!");
            alert.setContentText("Por favor, informe um valor para calcular o troco.");
            alert.showAndWait();
            System.err.println(Float.parseFloat(fieldGhob.getText()));
        } else if(fieldGhob.getText().matches("[0-9]+.[0-9]+")) {
        	if (total_money <= Float.parseFloat(fieldGhob.getText())){
        		ghob.setText(NumberFormat.getCurrencyInstance().format(Information.getGhob(Float.parseFloat(fieldGhob.getText()), total_money)) + " R$");
        	} else {
        		Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Valor inválido");
                alert.setHeaderText("Valor inválido");
                alert.setContentText("O valor informado deve ser maior que o total.");
                alert.showAndWait();
            }
        } else {
        	Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Valor inválido");
            alert.setHeaderText("Valor inválido");
            alert.setContentText("Por favor, informe um valor válido para calcular o troco.");
            alert.showAndWait();
        }
               
        
    }
    
    /**
     * Método que adiciona os meses em uma lista.
     */
    private void allMonth() {
        ObservableList<String> monthsbox = FXCollections.observableArrayList();
        month.setValue("Mês");
        for (int i = 1; i <= 12; i++) {
            monthsbox.add(String.valueOf(i));
            month.setValue(i);
            month.setItems(monthsbox);
        }
        month.setValue("Mês");
    }
    
    /**
     * Método que adiciona os anos à  partir do ano corrente em uma lista.
     */
    private void yearByCurrentYear() {
        
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        
        ObservableList<String> yearbox = FXCollections.observableArrayList();
        
        for (int i = currentYear ; i <= currentYear + 25; i++) {
        	yearbox.add(String.valueOf(i));
            year.setValue(i);
            year.setItems(yearbox);
        }
        year.setValue("Ano");
        
    }
    
    /**
     * Método que adiciona as parcelas em uma lista.
     */
    private void portion() {
        
        ObservableList<String> portionBox = FXCollections.observableArrayList();
        
        for (int i = 1 ; i <= 12; i++) {
        	portionBox.add(String.valueOf(i));
            portion.setValue(i);
            portion.setItems(portionBox);
        }
        portion.setValue("Portion");
        
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
    	
    	i_IControllerManager = initController();
    	
    	BankTransfer.initBankTransfer();
    	
    	card_type_v.setUserData(2);
    	
    	card_type_m.setUserData(1);
    	
    	bt_bank.setText(BankTransfer.getAgency());
    	
    	bt_name.setText(BankTransfer.getName());
    	
    	bt_number.setText(BankTransfer.getNumber());
    	
    	bt_agency.setText(BankTransfer.getAgency());
    	
    	bt_cpf.setText(BankTransfer.getCpf());
    	
    	int freight = Cart.getFreight();
    	
    	card_type.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
  	      public void changed(ObservableValue<? extends Toggle> ov,
  	          Toggle old_toggle, Toggle new_toggle) {
  	        if (card_type.getSelectedToggle() != null) {
  	        	if (card_type.getSelectedToggle().getUserData().toString().equals("2")) {
  	        		Information.setCardType(2);
  	        	} else {
  	        		Information.setCardType(1);
  	        	}
  	        }
  	      }
  	    });
    	
    	if (freight == 1) {
    		this.total_money = Cart.getTotalAmountFreight();
	        
	        this.total_creditCard = Cart.getTotalAmountFreight();
	        
	        this.total_bankInvoice = Cart.getTotalAmountFreight();
	        
	        this.total_bankTransfer = Cart.getTotalAmountFreight();
    	        
    	} else {
			this.total_money = Cart.getTotalAmount();
	        
	        this.total_creditCard = Cart.getTotalAmount();
	        
	        this.total_bankInvoice = Cart.getTotalAmount();
	        
	        this.total_bankTransfer = Cart.getTotalAmount();
    	    
    	}
    	
    	show_total_money.setText(NumberFormat.getCurrencyInstance().format(this.total_money) + " R$");
    	
    	show_total_creditCard.setText(NumberFormat.getCurrencyInstance().format(this.total_creditCard) + " R$");
    	
    	show_total_bankInvoice.setText(NumberFormat.getCurrencyInstance().format(this.total_bankInvoice) + " R$");
    	
    	show_total_bankTransfer.setText(NumberFormat.getCurrencyInstance().format(this.total_bankTransfer) + " R$");
    	
        ghob.setText("");
        
        fieldGhob.setText("");
        
        name.setText("");
        
        number.setText("");
        
        code.setText("");
        
        allMonth();
        
        yearByCurrentYear();
        
        portion();
    }     
    
}
