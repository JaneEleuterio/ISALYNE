package payment.core;

import payment.prov.IManager;
import payment.req.ICreditCardManager;
import payment.req.IBankTransferManager;
import payment.req.IBankInvoiceManager;
import payment.req.IMoneyPaymentManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: Payment
 * Component: Payment
 *
 * This class contains the concrete methods of component 'Payment'.
 */
public class PaymentM {
    private IManager manager;


		private ICreditCardManager i_ICreditCardManager;
		private IBankTransferManager i_IBankTransferManager;
		private IBankInvoiceManager i_IBankInvoiceManager;
		private IMoneyPaymentManager i_IMoneyPaymentManager;
    
    public PaymentM(IManager manager) {
        this.manager = manager;
    }

    private void getManagers() {
	

			this.i_ICreditCardManager =
	                (ICreditCardManager) manager.getRequiredInterface("ICreditCardManager");
			this.i_IBankTransferManager =
	                (IBankTransferManager) manager.getRequiredInterface("IBankTransferManager");
			this.i_IBankInvoiceManager =
	                (IBankInvoiceManager) manager.getRequiredInterface("IBankInvoiceManager");
			this.i_IMoneyPaymentManager =
	                (IMoneyPaymentManager) manager.getRequiredInterface("IMoneyPaymentManager");
        
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
    public synchronized boolean getDisponibilidadeVISAPayment(){
    	getManagers();
    	return i_ICreditCardManager.getDisponibilidadeVISA();
    }
	public synchronized boolean getDisponibilidadeMASTERPayment(){
		getManagers();
		return i_ICreditCardManager.getDisponibilidadeMASTER();
	}
    
    
    
    public synchronized String pagarComBoleto(float valor){
    	getManagers();
    	return i_IBankInvoiceManager.pagamentoBoleto(valor);
    }
    public synchronized String pagarComTransferencia(float valor){
    	getManagers();
    	return i_IBankTransferManager.pagamentoTransferencia(valor);
    }
    public synchronized float calcularTrocoREAL(float valorA , float valorB ){
    	getManagers();
    	return i_IMoneyPaymentManager.calcularTroco(valorA, valorB);
    }
	public synchronized boolean registrarCompraReal(){
		getManagers();
		return i_IMoneyPaymentManager.registrarCompra();
	}
	public synchronized String pagarComCartaoDeCredito(int cartao ,float valor ,String nomeCartao , String numeroCartao,String validadeCartao,String cifCartao,int parcelas){
		getManagers();
		String resu = null;
		if(cartao == 1)
			resu = i_ICreditCardManager.pagarMasterCredit(valor, nomeCartao, numeroCartao, validadeCartao, cifCartao,parcelas);
		if(cartao == 2)
			resu = i_ICreditCardManager.pagarVisaCredit(valor, nomeCartao, numeroCartao, validadeCartao, cifCartao,parcelas);
		return resu;
	}
}