package eShop.zCosmapek_Configurations;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 *
 * List of all provided interfaces.
 */
interface IInterfaceTags {
    //provided
    static final String IManagerProv = "IManager";

	//MAPEK Cosmos
    static final String ILauncherProv = "ILauncher";
    static final String IComponentManagerTag = "IComponentManager";
    static final String ISensorManagerTag = "ISensorManager";
    static final String IConnectorManagerTag = "IConnectorManager";
    static final String IFeatureManagerTag = "IFeatureManager";
    static final String IVariabilityManagerTag = "IVariabilityManager";
    static final String IReadingManagerTag = "IReadingManager";
    static final String IAnalysisManagerTag = "IAnalysisManager";
    static final String IPlanningManagerTag = "IPlanningManager";
    static final String IExecutionManagerTag = "IExecutionManager";
    static final String IControllerManagerTag = "IControllerManager";
    
	
    //to the application 
	static final String IGUIManagerTag = "IGUIManager";
	static final String ICatalogueManagerTag = "ICatalogueManager";
	static final String IPaymentManagerTag = "IPaymentManager";
	static final String IBankInvoiceManagerTag = "IBankInvoiceManager";
	static final String IBankTransferManagerTag = "IBankTransferManager";
	static final String ICreditCardManagerTag = "ICreditCardManager";
	static final String IMasterCardManagerTag = "IMasterCardManager";
	static final String IVisaManagerTag = "IVisaManager";
	static final String IMoneyPaymentManagerTag = "IMoneyPaymentManager";

	// to the fault tolerance
    // sensors 
	static final String ISensorUpdaterManagerTag = "ISensorUpdaterManager";
    static final String ISensorUpdaterTag ="ISensorUpdater";
   
}