package eShop;

import java.io.File;
import java.net.URI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.Cart;
import visaB.prov.IVisaManager;



/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 *
 * Instantiates the components by referencing its interfaces.
 */
public class Main extends Application implements IInterfaceTags{
	private static MapeKCosmosThread backgroundCosmos;
	//components 
	private static controller.prov.IManager comp_Controller;
	private static javaGrafics.prov.IManager comp_Java;
	private static catalogue.prov.IManager comp_Catalogue;
	private static payment.prov.IManager comp_Payment;
	private static bankInvoice.prov.IManager comp_BankInvoice;
	private static bankTransfer.prov.IManager comp_BankTransfer;
	private static creditCard.prov.IManager comp_CreditCard;
	private static masterCardA.prov.IManager comp_MasterCardA;
	private static masterCardB.prov.IManager comp_MasterCardB;
	private static visaA.prov.IManager comp_VisaA;
	private static visaB.prov.IManager comp_VisaB;
	private static visaC.prov.IManager comp_VisaC;
	private static moneyPayment.prov.IManager comp_MoneyPayment;
	
	//provided interfaces 	
	private static controller.prov.IControllerManager i_IControllerManager;	
	private static javaGrafics.prov.IGUIManager i_IGUIManager;	
	private static catalogue.prov.ICatalogueManager i_ICatalogueManager;	
	private static payment.prov.IPaymentManager i_IPaymentManager;	
	private static bankInvoice.prov.IBankInvoiceManager i_IBankInvoiceManager;	
	private static bankTransfer.prov.IBankTransferManager i_IBankTransferManager;	
	private static creditCard.prov.ICreditCardManager i_ICreditCardManager;	
	private static masterCardA.prov.IMasterCardManager i_IMasterCardManager;	
	private static visaA.prov.IVisaManager i_IVisaManager;	
	private static moneyPayment.prov.IMoneyPaymentManager i_IMoneyPaymentManager;
	
	//To the fault tolerance
	// todos os componentes alternativos, mas sem os sensors
	
	//connectors 
	private static conn_Java_Controller.prov.IManager c_conn_Java_Controller;
	private static conn_Catalogue_Controller.prov.IManager c_conn_Catalogue_Controller;
	private static conn_Payment_Controller.prov.IManager c_conn_Payment_Controller;
	private static conn_BankInvoice_Payment.prov.IManager c_conn_BankInvoice_Payment;
	private static conn_BankTransfer_Payment.prov.IManager c_conn_BankTransfer_Payment;
	private static conn_CreditCard_Payment.prov.IManager c_conn_CreditCard_Payment;
	private static conn_MasterCardA_CreditCard.prov.IManager c_conn_MasterCardA_CreditCard;
	private static conn_MasterCardB_CreditCard.prov.IManager c_conn_MasterCardB_CreditCard;
	private static conn_VisaA_CreditCard.prov.IManager c_conn_VisaA_CreditCard;
	private static conn_VisaB_CreditCard.prov.IManager c_conn_VisaB_CreditCard;
	private static conn_VisaC_CreditCard.prov.IManager c_conn_VisaC_CreditCard;
	private static conn_MoneyPayment_Payment.prov.IManager c_conn_MoneyPayment_Payment;
	
	
	//Interfaces alternativas !!
	private static masterCardB.prov.IMasterCardManager i_IMasterCardManagerB;
	private static visaB.prov.IVisaManager i_IVisaManagerB;
	private static visaC.prov.IVisaManager i_IVisaManagerC;
	
	/**
     * Método que inicia a primeira cena.
     * 
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        Cart.cartInitialize();
    	
    	Parent root = FXMLLoader.load(getClass().getResource("/javaGrafics/core/FXMLStartApp.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Buscar por produtos");
        stage.setScene(scene);
        stage.show();
        
        initCosMape();
		
        initComponents();
		
        executeCosmapek();
        
        try{//TODO: You can call a component by a provided interface
    		System.out.println("******************************");
    		System.out.println("******************************");
    		System.out.println("******************************");
    		boolean resu = i_IControllerManager.conectaVISA();
    		Thread.sleep(1000);
    		
    		System.out.println(resu);
    		
    		System.out.println("******************************");
    		System.out.println("******************************");
    		System.out.println("******************************");
    		}catch(Exception e){
    			
    		
    		}
        
    }
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	
	
	private static void executeCosmapek() {
		//configurations
		//C:\Users\ArchyWin\Dropbox\Codigos\TesteABC\TesteProdutoABCsrc_modificado
		//String resourcesPath = "file:///C:/eclipse/outroWS/TesteProdutoABCsrc_modificado/resource";
		String resourcesPath = "file:///C:/Users/Cris/eShop/resource";
		
		String effectorsPath = "eShop.zCosmapek_Configurations";
		File sdcard =  new File(URI.create(resourcesPath));
		File sdcard_config= new File(sdcard,"config.xml");
		File sdcard_variability= new File(sdcard,"variability.xml");
		backgroundCosmos=MapeKCosmosThreadFactory.createInstance(sdcard_variability.getPath(),sdcard_config.getPath(),effectorsPath);
		backgroundCosmos.start();
	}
	

	private static void initComponents() {

		//instantiating components 
		comp_Controller = controller.impl.ComponentFactory.createInstance();
		comp_Java = javaGrafics.impl.ComponentFactory.createInstance();
		comp_Catalogue = catalogue.impl.ComponentFactory.createInstance();
		comp_Payment = payment.impl.ComponentFactory.createInstance();
		comp_BankInvoice = bankInvoice.impl.ComponentFactory.createInstance();
		comp_BankTransfer = bankTransfer.impl.ComponentFactory.createInstance();
		comp_CreditCard = creditCard.impl.ComponentFactory.createInstance();
		comp_MasterCardA = masterCardA.impl.ComponentFactory.createInstance();
		comp_MasterCardB = masterCardB.impl.ComponentFactory.createInstance();
		comp_VisaA = visaA.impl.ComponentFactory.createInstance();
		comp_VisaB = visaB.impl.ComponentFactory.createInstance();
		comp_VisaC = visaC.impl.ComponentFactory.createInstance();
		comp_MoneyPayment = moneyPayment.impl.ComponentFactory.createInstance();
		
		//getting provided interfaces 	
		i_IControllerManager = (controller.prov.IControllerManager) comp_Controller.getProvidedInterface(IControllerManagerTag);	
		i_IGUIManager = (javaGrafics.prov.IGUIManager) comp_Java.getProvidedInterface(IGUIManagerTag);	
		i_ICatalogueManager = (catalogue.prov.ICatalogueManager) comp_Catalogue.getProvidedInterface(ICatalogueManagerTag);	
		i_IPaymentManager = (payment.prov.IPaymentManager) comp_Payment.getProvidedInterface(IPaymentManagerTag);	
		i_IBankInvoiceManager = (bankInvoice.prov.IBankInvoiceManager) comp_BankInvoice.getProvidedInterface(IBankInvoiceManagerTag);	
		i_IBankTransferManager = (bankTransfer.prov.IBankTransferManager) comp_BankTransfer.getProvidedInterface(IBankTransferManagerTag);	
		i_ICreditCardManager = (creditCard.prov.ICreditCardManager) comp_CreditCard.getProvidedInterface(ICreditCardManagerTag);	
		i_IMasterCardManager = (masterCardA.prov.IMasterCardManager) comp_MasterCardA.getProvidedInterface(IMasterCardManagerTag);	
		i_IVisaManager = (visaA.prov.IVisaManager) comp_VisaA.getProvidedInterface(IVisaManagerTag);	
		i_IMoneyPaymentManager = (moneyPayment.prov.IMoneyPaymentManager) comp_MoneyPayment.getProvidedInterface(IMoneyPaymentManagerTag);
		
		//instantiating Cosmos connectors 
		c_conn_Java_Controller = conn_Java_Controller.impl.ComponentFactory.createInstance();
		c_conn_Catalogue_Controller = conn_Catalogue_Controller.impl.ComponentFactory.createInstance();
		c_conn_Payment_Controller = conn_Payment_Controller.impl.ComponentFactory.createInstance();
		c_conn_BankInvoice_Payment = conn_BankInvoice_Payment.impl.ComponentFactory.createInstance();
		c_conn_BankTransfer_Payment = conn_BankTransfer_Payment.impl.ComponentFactory.createInstance();
		c_conn_CreditCard_Payment = conn_CreditCard_Payment.impl.ComponentFactory.createInstance();
		c_conn_MasterCardA_CreditCard = conn_MasterCardA_CreditCard.impl.ComponentFactory.createInstance();
		c_conn_MasterCardB_CreditCard = conn_MasterCardB_CreditCard.impl.ComponentFactory.createInstance();
		c_conn_VisaA_CreditCard = conn_VisaA_CreditCard.impl.ComponentFactory.createInstance();
		c_conn_VisaB_CreditCard = conn_VisaB_CreditCard.impl.ComponentFactory.createInstance();
		c_conn_VisaC_CreditCard = conn_VisaC_CreditCard.impl.ComponentFactory.createInstance();
		c_conn_MoneyPayment_Payment = conn_MoneyPayment_Payment.impl.ComponentFactory.createInstance();
		
		//setting required interfaces 
		c_conn_Java_Controller.setRequiredInterface(IGUIManagerTag, i_IGUIManager);
		comp_Controller.setRequiredInterface(IGUIManagerTag, c_conn_Java_Controller.getProvidedInterface(IGUIManagerTag)); 
		
		c_conn_Catalogue_Controller.setRequiredInterface(ICatalogueManagerTag, i_ICatalogueManager);
		comp_Controller.setRequiredInterface(ICatalogueManagerTag, c_conn_Catalogue_Controller.getProvidedInterface(ICatalogueManagerTag)); 
		
		c_conn_Payment_Controller.setRequiredInterface(IPaymentManagerTag, i_IPaymentManager);
		comp_Controller.setRequiredInterface(IPaymentManagerTag, c_conn_Payment_Controller.getProvidedInterface(IPaymentManagerTag)); 
		
		c_conn_BankInvoice_Payment.setRequiredInterface(IBankInvoiceManagerTag, i_IBankInvoiceManager);
		comp_Payment.setRequiredInterface(IBankInvoiceManagerTag, c_conn_BankInvoice_Payment.getProvidedInterface(IBankInvoiceManagerTag)); 
		
		c_conn_BankTransfer_Payment.setRequiredInterface(IBankTransferManagerTag, i_IBankTransferManager);
		comp_Payment.setRequiredInterface(IBankTransferManagerTag, c_conn_BankTransfer_Payment.getProvidedInterface(IBankTransferManagerTag)); 
		
		c_conn_CreditCard_Payment.setRequiredInterface(ICreditCardManagerTag, i_ICreditCardManager);
		comp_Payment.setRequiredInterface(ICreditCardManagerTag, c_conn_CreditCard_Payment.getProvidedInterface(ICreditCardManagerTag)); 
		
		c_conn_MasterCardA_CreditCard.setRequiredInterface(IMasterCardManagerTag, i_IMasterCardManager);
		comp_CreditCard.setRequiredInterface(IMasterCardManagerTag, c_conn_MasterCardA_CreditCard.getProvidedInterface(IMasterCardManagerTag)); 
		
		
		c_conn_VisaA_CreditCard.setRequiredInterface(IVisaManagerTag, i_IVisaManager);
		comp_CreditCard.setRequiredInterface(IVisaManagerTag, c_conn_VisaA_CreditCard.getProvidedInterface(IVisaManagerTag)); 
		
			
		c_conn_MoneyPayment_Payment.setRequiredInterface(IMoneyPaymentManagerTag, i_IMoneyPaymentManager);
		comp_Payment.setRequiredInterface(IMoneyPaymentManagerTag, c_conn_MoneyPayment_Payment.getProvidedInterface(IMoneyPaymentManagerTag)); 
		
		
		
		
		
	//Interfaces Alternativas !!
	//Instanciando interfaces alternativas!!
		
		i_IVisaManagerB = (visaB.prov.IVisaManager) comp_VisaB.getProvidedInterface(IVisaManagerTag);
		i_IMasterCardManagerB = (masterCardB.prov.IMasterCardManager) comp_MasterCardB.getProvidedInterface(IMasterCardManagerTag);
		

		
		//IMPORNTANTE CORRIGI AQUI, ALVARO. 
		//cada componente tem a sua interface setada
		
		c_conn_VisaB_CreditCard.setRequiredInterface(IVisaManagerTag, i_IVisaManager);
		//comp_CreditCard.setRequiredInterface(IVisaManagerTag, c_conn_VisaB_CreditCard.getProvidedInterface(IVisaManagerTag)); 
		
		c_conn_VisaC_CreditCard.setRequiredInterface(IVisaManagerTag, i_IVisaManager);
		//comp_CreditCard.setRequiredInterface(IVisaManagerTag, c_conn_VisaC_CreditCard.getProvidedInterface(IVisaManagerTag)); 
	
		c_conn_MasterCardB_CreditCard.setRequiredInterface(IMasterCardManagerTag, i_IMasterCardManager);
		//comp_CreditCard.setRequiredInterface(IMasterCardManagerTag, c_conn_MasterCardB_CreditCard.getProvidedInterface(IMasterCardManagerTag)); 
		
		
	}
	
		
	
	//MAPEK Cosmos
	//requirements
	private static cosmapek.components.prov.IManager comp;
	private static cosmapek.components.prov.IComponentManager compIComp;
	private static cosmapek.sensors.prov.IManager sens;
	private static cosmapek.sensors.prov.ISensorManager sensISens;
	private static cosmapek.connectors.prov.IManager conn;
	private static cosmapek.connectors.prov.IConnectorManager connIConn;
	private static cosmapek.features.prov.IManager feature;
	private static cosmapek.features.prov.IFeatureManager featureIFeature;
	private static cosmapek.variability.prov.IManager varia;
	private static cosmapek.variability.prov.IVariabilityManager variaIVaria;
	private static cosmapek.reader.prov.IManager reade;
	private static cosmapek.reader.prov.IReadingManager readeIReading;
	private static cosmapek.analyzer.prov.IManager analy;
	private static cosmapek.analyzer.prov.IAnalysisManager analyIAnaly;
	private static cosmapek.planner.prov.IManager plann;
	private static cosmapek.planner.prov.IPlanningManager plannIPlann;
	private static cosmapek.executer.prov.IManager execu;
	private static cosmapek.executer.prov.IExecutionManager execuIExecu;
	private static cosmapek.controller.prov.IManager controll;
	private static cosmapek.controller.prov.IControllerManager controllIControll;
	//mapekcosmos.connectors
	private static cosmapek.conn_analyzer_controller.prov.IManager analy_controll;
	private static cosmapek.conn_analyzer_planner.prov.IManager analy_plann;
	private static cosmapek.conn_components_connectors.prov.IManager comp_conn;
	private static cosmapek.conn_components_planner.prov.IManager comp_plann;
	private static cosmapek.conn_components_reader.prov.IManager comp_reade;
	private static cosmapek.conn_components_variability.prov.IManager comp_varia;
	private static cosmapek.conn_connectors_planner.prov.IManager conn_plann;
	private static cosmapek.conn_connectors_reader.prov.IManager conn_reade;
	private static cosmapek.conn_connectors_variability.prov.IManager conn_varia;
	//private static cosmapek.conn_controller_main.prov.IManager controll_mainM;
	private static cosmapek.conn_executer_controller.prov.IManager execu_controll;
	private static cosmapek.conn_features_reader.prov.IManager feature_reade;
	private static cosmapek.conn_features_variability.prov.IManager feature_varia;
	private static cosmapek.conn_planner_controller.prov.IManager plann_controll;
	private static cosmapek.conn_planner_executer.prov.IManager plann_execu;
	//private static cosmapek.conn_reader_main.prov.IManager reade_mainM;
	private static cosmapek.conn_sensors_analyzer.prov.IManager sens_analy;
	private static cosmapek.conn_sensors_connectors.prov.IManager sens_conn;
	private static cosmapek.conn_sensors_planner.prov.IManager sens_plann;
	private static cosmapek.conn_sensors_reader.prov.IManager sens_reade;
	private static cosmapek.conn_sensors_variability.prov.IManager sens_varia;
	private static cosmapek.conn_variability_planner.prov.IManager varia_plann;
	private static cosmapek.conn_variability_reader.prov.IManager varia_reade;

	private static void initCosMape(){
		// To the mapekcosmos
		comp = cosmapek.components.impl.ComponentFactory.createInstance();
		compIComp =
				(cosmapek.components.prov.IComponentManager) comp.getProvidedInterface(IComponentManagerTag);
		sens = cosmapek.sensors.impl.ComponentFactory.createInstance();
		sensISens = (cosmapek.sensors.prov.ISensorManager) sens.getProvidedInterface(ISensorManagerTag);

		conn = cosmapek.connectors.impl.ComponentFactory.createInstance();
		//mapekcosmos.connectors to conn
		comp_conn = cosmapek.conn_components_connectors.impl.ComponentFactory.createInstance();
		comp_conn.setRequiredInterface(IComponentManagerTag, compIComp);
		sens_conn = cosmapek.conn_sensors_connectors.impl.ComponentFactory.createInstance();
		sens_conn.setRequiredInterface(ISensorManagerTag, sensISens);
		//sets
		conn.setRequiredInterface(IComponentManagerTag,
				comp_conn.getProvidedInterface(IComponentManagerTag));
		conn.setRequiredInterface(ISensorManagerTag,
				sens_conn.getProvidedInterface(ISensorManagerTag));
		connIConn =
				(cosmapek.connectors.prov.IConnectorManager) conn.getProvidedInterface(IConnectorManagerTag);

		feature = cosmapek.features.impl.ComponentFactory.createInstance();
		featureIFeature =
				(cosmapek.features.prov.IFeatureManager) feature.getProvidedInterface(IFeatureManagerTag);

		varia = cosmapek.variability.impl.ComponentFactory.createInstance();
		//mapekcosmos.connectors to varia
		comp_varia = cosmapek.conn_components_variability.impl.ComponentFactory.createInstance();
		comp_varia.setRequiredInterface(IComponentManagerTag, compIComp);
		sens_varia = cosmapek.conn_sensors_variability.impl.ComponentFactory.createInstance();
		sens_varia.setRequiredInterface(ISensorManagerTag, sensISens);
		feature_varia = cosmapek.conn_features_variability.impl.ComponentFactory.createInstance();
		feature_varia.setRequiredInterface(IFeatureManagerTag, featureIFeature);
		conn_varia = cosmapek.conn_connectors_variability.impl.ComponentFactory.createInstance();
		conn_varia.setRequiredInterface(IConnectorManagerTag, connIConn);
		//sets
		varia.setRequiredInterface(IComponentManagerTag,
				comp_varia.getProvidedInterface(IComponentManagerTag));
		varia.setRequiredInterface(ISensorManagerTag,
				sens_varia.getProvidedInterface(ISensorManagerTag));
		varia.setRequiredInterface(IFeatureManagerTag,
				feature_varia.getProvidedInterface(IFeatureManagerTag));
		varia.setRequiredInterface(IConnectorManagerTag,
				conn_varia.getProvidedInterface(IConnectorManagerTag));
		variaIVaria = (cosmapek.variability.prov.IVariabilityManager) varia
				.getProvidedInterface(IVariabilityManagerTag);

		reade = cosmapek.reader.impl.ComponentFactory.createInstance();
		//mapekcosmos.connectors to reade
		comp_reade = cosmapek.conn_components_reader.impl.ComponentFactory.createInstance();
		comp_reade.setRequiredInterface(IComponentManagerTag, compIComp);
		sens_reade = cosmapek.conn_sensors_reader.impl.ComponentFactory.createInstance();
		sens_reade.setRequiredInterface(ISensorManagerTag, sensISens);
		conn_reade = cosmapek.conn_connectors_reader.impl.ComponentFactory.createInstance();
		conn_reade.setRequiredInterface(IConnectorManagerTag, connIConn);
		feature_reade = cosmapek.conn_features_reader.impl.ComponentFactory.createInstance();
		feature_reade.setRequiredInterface(IFeatureManagerTag, featureIFeature);
		varia_reade = cosmapek.conn_variability_reader.impl.ComponentFactory.createInstance();
		varia_reade.setRequiredInterface(IVariabilityManagerTag, variaIVaria);
		//sets
		reade.setRequiredInterface(IComponentManagerTag,
				comp_reade.getProvidedInterface(IComponentManagerTag));
		reade.setRequiredInterface(ISensorManagerTag,
				sens_reade.getProvidedInterface(ISensorManagerTag));
		reade.setRequiredInterface(IConnectorManagerTag,
				conn_reade.getProvidedInterface(IConnectorManagerTag));
		reade.setRequiredInterface(IFeatureManagerTag,//
				feature_reade.getProvidedInterface(IFeatureManagerTag));
		reade.setRequiredInterface(IVariabilityManagerTag,
				varia_reade.getProvidedInterface(IVariabilityManagerTag));
		readeIReading =
				(cosmapek.reader.prov.IReadingManager) reade.getProvidedInterface(IReadingManagerTag);

		analy = cosmapek.analyzer.impl.ComponentFactory.createInstance();
		//mapekcosmos.connectors to analy
		sens_analy = cosmapek.conn_sensors_analyzer.impl.ComponentFactory.createInstance();
		sens_analy.setRequiredInterface(ISensorManagerTag, sensISens);
		//sets
		analy.setRequiredInterface(ISensorManagerTag,
				sens_analy.getProvidedInterface(ISensorManagerTag));
		analyIAnaly =
				(cosmapek.analyzer.prov.IAnalysisManager) analy.getProvidedInterface(IAnalysisManagerTag);

		plann = cosmapek.planner.impl.ComponentFactory.createInstance();
		//mapekcosmos.connectors to plan
		comp_plann = cosmapek.conn_components_planner.impl.ComponentFactory.createInstance();
		comp_plann.setRequiredInterface(IComponentManagerTag, compIComp);
		sens_plann = cosmapek.conn_sensors_planner.impl.ComponentFactory.createInstance();
		sens_plann.setRequiredInterface(ISensorManagerTag, sensISens);
		conn_plann = cosmapek.conn_connectors_planner.impl.ComponentFactory.createInstance();
		conn_plann.setRequiredInterface(IConnectorManagerTag, connIConn);
		varia_plann = cosmapek.conn_variability_planner.impl.ComponentFactory.createInstance();
		varia_plann.setRequiredInterface(IVariabilityManagerTag, variaIVaria);
		analy_plann = cosmapek.conn_analyzer_planner.impl.ComponentFactory.createInstance();
		analy_plann.setRequiredInterface(IAnalysisManagerTag, analyIAnaly);
		//sets
		plann.setRequiredInterface(IComponentManagerTag,
				comp_plann.getProvidedInterface(IComponentManagerTag));
		plann.setRequiredInterface(ISensorManagerTag,
				sens_plann.getProvidedInterface(ISensorManagerTag));
		plann.setRequiredInterface(IConnectorManagerTag,
				conn_plann.getProvidedInterface(IConnectorManagerTag));
		plann.setRequiredInterface(IVariabilityManagerTag,
				varia_plann.getProvidedInterface(IVariabilityManagerTag));
		plann.setRequiredInterface(IAnalysisManagerTag,
				analy_plann.getProvidedInterface(IAnalysisManagerTag));
		plannIPlann =
				(cosmapek.planner.prov.IPlanningManager) plann.getProvidedInterface(IPlanningManagerTag);

		execu = cosmapek.executer.impl.ComponentFactory.createInstance();
		//mapekcosmos.connectors to execu
		plann_execu = cosmapek.conn_planner_executer.impl.ComponentFactory.createInstance();
		plann_execu.setRequiredInterface(IPlanningManagerTag, plannIPlann);
		//seters to execu
		execu.setRequiredInterface(IPlanningManagerTag,
				plann_execu.getProvidedInterface(IPlanningManagerTag));
		execuIExecu =
				(cosmapek.executer.prov.IExecutionManager) execu.getProvidedInterface(IExecutionManagerTag);

		controll = cosmapek.controller.impl.ComponentFactory.createInstance();
		//mapekcosmos.connectors to controll
		analy_controll = cosmapek.conn_analyzer_controller.impl.ComponentFactory.createInstance();
		analy_controll.setRequiredInterface(IAnalysisManagerTag, analyIAnaly);
		plann_controll = cosmapek.conn_planner_controller.impl.ComponentFactory.createInstance();
		plann_controll.setRequiredInterface(IPlanningManagerTag, plannIPlann);
		execu_controll = cosmapek.conn_executer_controller.impl.ComponentFactory.createInstance();
		execu_controll.setRequiredInterface(IExecutionManagerTag, execuIExecu);
		//setters to control
		controll.setRequiredInterface(IAnalysisManagerTag,
				analy_controll.getProvidedInterface(IAnalysisManagerTag));
		controll.setRequiredInterface(IPlanningManagerTag,
				plann_controll.getProvidedInterface(IPlanningManagerTag));
		controll.setRequiredInterface(IExecutionManagerTag,
				execu_controll.getProvidedInterface(IExecutionManagerTag));

		controllIControll = (cosmapek.controller.prov.IControllerManager) controll
				.getProvidedInterface(IControllerManagerTag);
				
				
	}
}