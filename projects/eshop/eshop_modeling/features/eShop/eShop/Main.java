package eShop;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 *
 * Instantiates the components by referencing its interfaces.
 */
public class Main implements IInterfaceTags{

	//components 
	private static controller.prov.IManager comp_Controller;
	private static java.prov.IManager comp_Java;
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
	private static java.prov.IGUIManager i_IGUIManager;	
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
	
	
	
	public static void main(String[] args) {
		initCosMape();
		init();
		

		//TODO: You can call a component by a provided interface

	}
	

	private static void init() {

		//instantiating components 
		comp_Controller = controller.impl.ComponentFactory.createInstance();
		comp_Java = java.impl.ComponentFactory.createInstance();
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
		i_IGUIManager = (java.prov.IGUIManager) comp_Java.getProvidedInterface(IGUIManagerTag);	
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
		
		c_conn_MasterCardB_CreditCard.setRequiredInterface(IMasterCardManagerTag, i_IMasterCardManager);
		comp_CreditCard.setRequiredInterface(IMasterCardManagerTag, c_conn_MasterCardB_CreditCard.getProvidedInterface(IMasterCardManagerTag)); 
		
		c_conn_VisaA_CreditCard.setRequiredInterface(IVisaManagerTag, i_IVisaManager);
		comp_CreditCard.setRequiredInterface(IVisaManagerTag, c_conn_VisaA_CreditCard.getProvidedInterface(IVisaManagerTag)); 
		
		c_conn_VisaB_CreditCard.setRequiredInterface(IVisaManagerTag, i_IVisaManager);
		comp_CreditCard.setRequiredInterface(IVisaManagerTag, c_conn_VisaB_CreditCard.getProvidedInterface(IVisaManagerTag)); 
		
		c_conn_VisaC_CreditCard.setRequiredInterface(IVisaManagerTag, i_IVisaManager);
		comp_CreditCard.setRequiredInterface(IVisaManagerTag, c_conn_VisaC_CreditCard.getProvidedInterface(IVisaManagerTag)); 
		
		c_conn_MoneyPayment_Payment.setRequiredInterface(IMoneyPaymentManagerTag, i_IMoneyPaymentManager);
		comp_Payment.setRequiredInterface(IMoneyPaymentManagerTag, c_conn_MoneyPayment_Payment.getProvidedInterface(IMoneyPaymentManagerTag)); 
		
		
	}
	
		
	
	//MAPEK Cosmos
	//requirements
	private static mapekcosmos.components.prov.IManager comp;
	private static mapekcosmos.components.prov.IComponentManager compIComp;
	private static mapekcosmos.sensors.prov.IManager sens;
	private static mapekcosmos.sensors.prov.ISensorManager sensISens;
	private static mapekcosmos.connectors.prov.IManager conn;
	private static mapekcosmos.connectors.prov.IConnectorManager connIConn;
	private static mapekcosmos.features.prov.IManager feature;
	private static mapekcosmos.features.prov.IFeatureManager featureIFeature;
	private static mapekcosmos.variability.prov.IManager varia;
	private static mapekcosmos.variability.prov.IVariabilityManager variaIVaria;
	private static mapekcosmos.reader.prov.IManager reade;
	private static mapekcosmos.reader.prov.IReadingManager readeIReading;
	private static mapekcosmos.analyzer.prov.IManager analy;
	private static mapekcosmos.analyzer.prov.IAnalysisManager analyIAnaly;
	private static mapekcosmos.planner.prov.IManager plann;
	private static mapekcosmos.planner.prov.IPlanningManager plannIPlann;
	private static mapekcosmos.executer.prov.IManager execu;
	private static mapekcosmos.executer.prov.IExecutionManager execuIExecu;
	private static mapekcosmos.controller.prov.IManager controll;
	private static mapekcosmos.controller.prov.IControllerManager controllIControll;
	//mapekcosmos.connectors
	private static mapekcosmos.conn_analyzer_controller.prov.IManager analy_controll;
	private static mapekcosmos.conn_analyzer_planner.prov.IManager analy_plann;
	private static mapekcosmos.conn_components_connectors.prov.IManager comp_conn;
	private static mapekcosmos.conn_components_planner.prov.IManager comp_plann;
	private static mapekcosmos.conn_components_reader.prov.IManager comp_reade;
	private static mapekcosmos.conn_components_variability.prov.IManager comp_varia;
	private static mapekcosmos.conn_connectors_planner.prov.IManager conn_plann;
	private static mapekcosmos.conn_connectors_reader.prov.IManager conn_reade;
	private static mapekcosmos.conn_connectors_variability.prov.IManager conn_varia;
	private static mapekcosmos.conn_controller_main.prov.IManager controll_mainM;
	private static mapekcosmos.conn_executer_controller.prov.IManager execu_controll;
	private static mapekcosmos.conn_features_reader.prov.IManager feature_reade;
	private static mapekcosmos.conn_features_variability.prov.IManager feature_varia;
	private static mapekcosmos.conn_planner_controller.prov.IManager plann_controll;
	private static mapekcosmos.conn_planner_executer.prov.IManager plann_execu;
	private static mapekcosmos.conn_reader_main.prov.IManager reade_mainM;
	private static mapekcosmos.conn_sensors_analyzer.prov.IManager sens_analy;
	private static mapekcosmos.conn_sensors_connectors.prov.IManager sens_conn;
	private static mapekcosmos.conn_sensors_planner.prov.IManager sens_plann;
	private static mapekcosmos.conn_sensors_reader.prov.IManager sens_reade;
	private static mapekcosmos.conn_sensors_variability.prov.IManager sens_varia;
	private static mapekcosmos.conn_variability_planner.prov.IManager varia_plann;
	private static mapekcosmos.conn_variability_reader.prov.IManager varia_reade;

	private static void initCosMape(){
		// To the mapekcosmos
		comp = mapekcosmos.components.impl.ComponentFactory.createInstance();
		compIComp =
				(mapekcosmos.components.prov.IComponentManager) comp.getProvidedInterface(IComponentManagerTag);
		sens = mapekcosmos.sensors.impl.ComponentFactory.createInstance();
		sensISens = (mapekcosmos.sensors.prov.ISensorManager) sens.getProvidedInterface(ISensorManagerTag);

		conn = mapekcosmos.connectors.impl.ComponentFactory.createInstance();
		//mapekcosmos.connectors to conn
		comp_conn = mapekcosmos.conn_components_connectors.impl.ComponentFactory.createInstance();
		comp_conn.setRequiredInterface(IComponentManagerTag, compIComp);
		sens_conn = mapekcosmos.conn_sensors_connectors.impl.ComponentFactory.createInstance();
		sens_conn.setRequiredInterface(ISensorManagerTag, sensISens);
		//sets
		conn.setRequiredInterface(IComponentManagerTag,
				comp_conn.getProvidedInterface(IComponentManagerTag));
		conn.setRequiredInterface(ISensorManagerTag,
				sens_conn.getProvidedInterface(ISensorManagerTag));
		connIConn =
				(mapekcosmos.connectors.prov.IConnectorManager) conn.getProvidedInterface(IConnectorManagerTag);

		feature = mapekcosmos.features.impl.ComponentFactory.createInstance();
		featureIFeature =
				(mapekcosmos.features.prov.IFeatureManager) feature.getProvidedInterface(IFeatureManagerTag);

		varia = mapekcosmos.variability.impl.ComponentFactory.createInstance();
		//mapekcosmos.connectors to varia
		comp_varia = mapekcosmos.conn_components_variability.impl.ComponentFactory.createInstance();
		comp_varia.setRequiredInterface(IComponentManagerTag, compIComp);
		sens_varia = mapekcosmos.conn_sensors_variability.impl.ComponentFactory.createInstance();
		sens_varia.setRequiredInterface(ISensorManagerTag, sensISens);
		feature_varia = mapekcosmos.conn_features_variability.impl.ComponentFactory.createInstance();
		feature_varia.setRequiredInterface(IFeatureManagerTag, featureIFeature);
		conn_varia = mapekcosmos.conn_connectors_variability.impl.ComponentFactory.createInstance();
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
		variaIVaria = (mapekcosmos.variability.prov.IVariabilityManager) varia
				.getProvidedInterface(IVariabilityManagerTag);

		reade = mapekcosmos.reader.impl.ComponentFactory.createInstance();
		//mapekcosmos.connectors to reade
		comp_reade = mapekcosmos.conn_components_reader.impl.ComponentFactory.createInstance();
		comp_reade.setRequiredInterface(IComponentManagerTag, compIComp);
		sens_reade = mapekcosmos.conn_sensors_reader.impl.ComponentFactory.createInstance();
		sens_reade.setRequiredInterface(ISensorManagerTag, sensISens);
		conn_reade = mapekcosmos.conn_connectors_reader.impl.ComponentFactory.createInstance();
		conn_reade.setRequiredInterface(IConnectorManagerTag, connIConn);
		feature_reade = mapekcosmos.conn_features_reader.impl.ComponentFactory.createInstance();
		feature_reade.setRequiredInterface(IFeatureManagerTag, featureIFeature);
		varia_reade = mapekcosmos.conn_variability_reader.impl.ComponentFactory.createInstance();
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
				(mapekcosmos.reader.prov.IReadingManager) reade.getProvidedInterface(IReadingManagerTag);

		analy = mapekcosmos.analyzer.impl.ComponentFactory.createInstance();
		//mapekcosmos.connectors to analy
		sens_analy = mapekcosmos.conn_sensors_analyzer.impl.ComponentFactory.createInstance();
		sens_analy.setRequiredInterface(ISensorManagerTag, sensISens);
		//sets
		analy.setRequiredInterface(ISensorManagerTag,
				sens_analy.getProvidedInterface(ISensorManagerTag));
		analyIAnaly =
				(mapekcosmos.analyzer.prov.IAnalysisManager) analy.getProvidedInterface(IAnalysisManagerTag);

		plann = mapekcosmos.planner.impl.ComponentFactory.createInstance();
		//mapekcosmos.connectors to plan
		comp_plann = mapekcosmos.conn_components_planner.impl.ComponentFactory.createInstance();
		comp_plann.setRequiredInterface(IComponentManagerTag, compIComp);
		sens_plann = mapekcosmos.conn_sensors_planner.impl.ComponentFactory.createInstance();
		sens_plann.setRequiredInterface(ISensorManagerTag, sensISens);
		conn_plann = mapekcosmos.conn_connectors_planner.impl.ComponentFactory.createInstance();
		conn_plann.setRequiredInterface(IConnectorManagerTag, connIConn);
		varia_plann = mapekcosmos.conn_variability_planner.impl.ComponentFactory.createInstance();
		varia_plann.setRequiredInterface(IVariabilityManagerTag, variaIVaria);
		analy_plann = mapekcosmos.conn_analyzer_planner.impl.ComponentFactory.createInstance();
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
				(mapekcosmos.planner.prov.IPlanningManager) plann.getProvidedInterface(IPlanningManagerTag);

		execu = mapekcosmos.executer.impl.ComponentFactory.createInstance();
		//mapekcosmos.connectors to execu
		plann_execu = mapekcosmos.conn_planner_executer.impl.ComponentFactory.createInstance();
		plann_execu.setRequiredInterface(IPlanningManagerTag, plannIPlann);
		//seters to execu
		execu.setRequiredInterface(IPlanningManagerTag,
				plann_execu.getProvidedInterface(IPlanningManagerTag));
		execuIExecu =
				(mapekcosmos.executer.prov.IExecutionManager) execu.getProvidedInterface(IExecutionManagerTag);

		controll = mapekcosmos.controller.impl.ComponentFactory.createInstance();
		//mapekcosmos.connectors to controll
		analy_controll = mapekcosmos.conn_analyzer_controller.impl.ComponentFactory.createInstance();
		analy_controll.setRequiredInterface(IAnalysisManagerTag, analyIAnaly);
		plann_controll = mapekcosmos.conn_planner_controller.impl.ComponentFactory.createInstance();
		plann_controll.setRequiredInterface(IPlanningManagerTag, plannIPlann);
		execu_controll = mapekcosmos.conn_executer_controller.impl.ComponentFactory.createInstance();
		execu_controll.setRequiredInterface(IExecutionManagerTag, execuIExecu);
		//setters to control
		controll.setRequiredInterface(IAnalysisManagerTag,
				analy_controll.getProvidedInterface(IAnalysisManagerTag));
		controll.setRequiredInterface(IPlanningManagerTag,
				plann_controll.getProvidedInterface(IPlanningManagerTag));
		controll.setRequiredInterface(IExecutionManagerTag,
				execu_controll.getProvidedInterface(IExecutionManagerTag));

		controllIControll = (mapekcosmos.controller.prov.IControllerManager) controll
				.getProvidedInterface(IControllerManagerTag);
				
				
	}
}