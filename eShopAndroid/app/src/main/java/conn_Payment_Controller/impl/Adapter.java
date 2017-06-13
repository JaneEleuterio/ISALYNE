package conn_Payment_Controller.impl;

import conn_Payment_Controller.prov.IManager;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: Payment
 * Component: Conn_Payment_Controller
 */
class Adapter
    implements controller.req.IPaymentManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

	//TODO: Adaptation of business methods
	//This class connects the business methods of the 
	//required interface 'controller.req.IPaymentManager' 
	//with business methods from the provided interface
	//'payment.prov.IPaymentManager'	
	
	//example of a business method
	/*
	@Override
    public synchronized type businessMethod(param){
        payment.prov.IPaymentManager comp_payment =
                (payment.prov.IPaymentManager) this.manager.getRequiredInterface(IPaymentManagerTag);
        return comp_payment.businessMethod(param);
    }
	*/
    public synchronized boolean getDisponibilidadeVISAPayment(){
    	payment.prov.IPaymentManager comp_payment =
                (payment.prov.IPaymentManager) this.manager.getRequiredInterface(IPaymentManagerTag);
        return comp_payment.getDisponibilidadeVISAPayment();
    }
    public synchronized boolean getDisponibilidadeMASTERPayment(){
    	payment.prov.IPaymentManager comp_payment =
                (payment.prov.IPaymentManager) this.manager.getRequiredInterface(IPaymentManagerTag);
        return comp_payment.getDisponibilidadeMASTERPayment();
    }
    
    public synchronized String pagarComBoleto(float valor){
    	 payment.prov.IPaymentManager comp_payment =
                 (payment.prov.IPaymentManager) this.manager.getRequiredInterface(IPaymentManagerTag);
         return comp_payment.pagarComBoleto(valor);
    }
    public synchronized String pagarComTransferencia(float valor){
    	 payment.prov.IPaymentManager comp_payment =
                 (payment.prov.IPaymentManager) this.manager.getRequiredInterface(IPaymentManagerTag);
         return comp_payment.pagarComTransferencia(valor);
    }
    public synchronized float calcularTrocoREAL(float valorA , float valorB ){
    	 payment.prov.IPaymentManager comp_payment =
                 (payment.prov.IPaymentManager) this.manager.getRequiredInterface(IPaymentManagerTag);
         return comp_payment.calcularTrocoREAL(valorA, valorB);
    }
	public synchronized boolean registrarCompraReal(){
		 payment.prov.IPaymentManager comp_payment =
	                (payment.prov.IPaymentManager) this.manager.getRequiredInterface(IPaymentManagerTag);
	        return comp_payment.registrarCompraReal();
	}
	public synchronized String pagarComCartaoDeCredito(int cartao ,float valor ,String nomeCartao , String numeroCartao,String validadeCartao,String cifCartao,int parcelas){
		 payment.prov.IPaymentManager comp_payment =
	                (payment.prov.IPaymentManager) this.manager.getRequiredInterface(IPaymentManagerTag);
		 return comp_payment.pagarComCartaoDeCredito(cartao, valor, nomeCartao, numeroCartao, validadeCartao, cifCartao,parcelas);
	}
}