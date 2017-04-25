package controller.impl;

import utils.Produto;
import controller.core.ControllerM;
import controller.core.ControllerMFactory;
import controller.prov.IManager;
import controller.prov.IControllerManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: App
 * Component: Controller
 */
class IControllerManagerFacade implements IInterfaceTags, IControllerManager {


    private IManager manager = null;
    private ControllerM controllerM;

    IControllerManagerFacade(IManager manager) {
        this.manager = manager;
        this.controllerM = ControllerMFactory.createInstance(this.manager);
    }

    //TODO: Each business method from the interface 'IControllerManager'
	//must be implemented here by invoking its method in the concrete 
	//component  Controller and with 'synchronized' notation
	
	//example of a business method 
	/*
	public synchronized type businessMethod(param) {
        return  controllerM.businessMethod(param);
    }
	*/
    public synchronized boolean conectaVISA(){
    	return controllerM.conectaVISA();
    }
    public synchronized boolean conectaMASTER(){
    	return controllerM.conectaMASTER();
    }
    public synchronized Produto buscaProdutoController(String nome){
    	return controllerM.buscaProdutoController(nome);
    }
    public synchronized String pagarComBoletoController(float valor){
    	return controllerM.pagarComBoletoController(valor);
    }
	public synchronized String pagarComTransferenciaController(float valor){
		return controllerM.pagarComTransferenciaController(valor);
	}
	public synchronized float calcularTrocoREALController(float valorA , float valorB ){
		return controllerM.calcularTrocoREALController(valorA, valorB);
	}
	public synchronized boolean registrarCompraRealController(){
		return controllerM.registrarCompraRealController();
	}
	public synchronized String pagarComCartaoDeCreditoController(int cartao ,float valor ,String nomeCartao , String numeroCartao,String validadeCartao,String cifCartao,int parcelas){
		return controllerM.pagarComCartaoDeCreditoController(cartao, valor, nomeCartao, numeroCartao, validadeCartao, cifCartao, parcelas);
	}
}