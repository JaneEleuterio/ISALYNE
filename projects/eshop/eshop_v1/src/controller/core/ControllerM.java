package controller.core;

import utils.Produto;
import controller.prov.IManager;
import controller.req.ICatalogueManager;
import controller.req.IPaymentManager;
import controller.req.IGUIManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: App
 * Component: Controller
 *
 * This class contains the concrete methods of component 'Controller'.
 */
public class ControllerM {
    private IManager manager;


		private ICatalogueManager i_ICatalogueManager;
		private IPaymentManager i_IPaymentManager;
		private IGUIManager i_IGUIManager;
    
    public ControllerM(IManager manager) {
        this.manager = manager;
    }

    private void getManagers() {
	

			this.i_ICatalogueManager =
	                (ICatalogueManager) manager.getRequiredInterface("ICatalogueManager");
			this.i_IPaymentManager =
	                (IPaymentManager) manager.getRequiredInterface("IPaymentManager");
			this.i_IGUIManager =
	                (IGUIManager) manager.getRequiredInterface("IGUIManager");
        
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
    public synchronized boolean conectaVISA(){
    	getManagers();
    	return i_IPaymentManager.getDisponibilidadeVISAPayment();
    }
    public synchronized boolean conectaMASTER(){
    	getManagers();
    	return i_IPaymentManager.getDisponibilidadeMASTERPayment();
    }
    public synchronized Produto buscaProdutoController(String nome){
    	getManagers();
    	return i_ICatalogueManager.buscaProduto(nome);
    }
    public synchronized String pagarComBoletoController(float valor){
    	getManagers();
    	return i_IPaymentManager.pagarComBoleto(valor);
    }
	public synchronized String pagarComTransferenciaController(float valor){
		getManagers();
		return i_IPaymentManager.pagarComTransferencia(valor);
	}
	public synchronized float calcularTrocoREALController(float valorA , float valorB ){
		getManagers();
		return i_IPaymentManager.calcularTrocoREAL(valorA, valorB);
	}
	public synchronized boolean registrarCompraRealController(){
		getManagers();
		return i_IPaymentManager.registrarCompraReal();
	}
	public synchronized String pagarComCartaoDeCreditoController(int cartao ,float valor ,String nomeCartao , String numeroCartao,String validadeCartao,String cifCartao,int parcelas){
		getManagers();
		return i_IPaymentManager.pagarComCartaoDeCredito(cartao, valor, nomeCartao, numeroCartao, validadeCartao, cifCartao, parcelas);
	}
    
}