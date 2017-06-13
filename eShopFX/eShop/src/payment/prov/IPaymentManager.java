package payment.prov;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: Payment
 * Component: Payment
 * 
 * This 'IPaymentManager' interface is provided by the component 'Payment'. All 
 * signatures to business methods present here should be updated on the components that 
 * have this 'IPaymentManager' interface as required.
 */
public interface IPaymentManager {
	public String pagarComBoleto(float valor);
	public String pagarComTransferencia(float valor);
	public float calcularTrocoREAL(float valorA , float valorB );
	public boolean registrarCompraReal();
	public String pagarComCartaoDeCredito(int cartao ,float valor ,String nomeCartao , String numeroCartao,String validadeCartao,String cifCartao,int parcelas);
	public boolean getDisponibilidadeVISAPayment();
	public boolean getDisponibilidadeMASTERPayment();
	
	

    //TODO: Signatures of business methods

	//This interface must be equivalent to the 
	//required interfaces in client components
}