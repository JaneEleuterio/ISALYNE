package payment.impl;

import payment.core.PaymentM;
import payment.core.PaymentMFactory;
import payment.prov.IManager;
import payment.prov.IPaymentManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: Payment
 * Component: Payment
 */
class IPaymentManagerFacade implements IInterfaceTags, IPaymentManager {


    private IManager manager = null;
    private PaymentM paymentM;

    IPaymentManagerFacade(IManager manager) {
        this.manager = manager;
        this.paymentM = PaymentMFactory.createInstance(this.manager);
    }

    //TODO: Each business method from the interface 'IPaymentManager'
	//must be implemented here by invoking its method in the concrete 
	//component  Payment and with 'synchronized' notation
	
	//example of a business method 
	/*
	public synchronized type businessMethod(param) {
        return  paymentM.businessMethod(param);
    }
	*/
    public synchronized String pagarComBoleto(float valor){
    	return paymentM.pagarComBoleto(valor);
    }
	public synchronized String pagarComTransferencia(float valor){
		return paymentM.pagarComTransferencia(valor);
	}
	public synchronized float calcularTrocoREAL(float valorA , float valorB ){
		return paymentM.calcularTrocoREAL(valorA, valorB);
	}
	public synchronized boolean registrarCompraReal(){
		return paymentM.registrarCompraReal();
	}
	public synchronized String pagarComCartaoDeCredito(int cartao ,float valor ,String nomeCartao , String numeroCartao,String validadeCartao,String cifCartao,int parcelas){
		return paymentM.pagarComCartaoDeCredito(cartao, valor, nomeCartao, numeroCartao, validadeCartao, cifCartao,parcelas);
	}
	public synchronized boolean getDisponibilidadeVISAPayment(){
		return paymentM.getDisponibilidadeVISAPayment();
	}
	public synchronized boolean getDisponibilidadeMASTERPayment(){
		return paymentM.getDisponibilidadeMASTERPayment();
	}
}