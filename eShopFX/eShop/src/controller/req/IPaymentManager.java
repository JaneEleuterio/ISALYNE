package controller.req;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: App
 * Component: Controller
 * 
 * This interface is required by the 'Controller' component (Controller.req.IPaymentManager). 
 * All signatures of business methods present here must be present in the 'IPaymentManager' interface 
 * on the component origin (Payment.prov.IPaymentManager).
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

	//This interface must be equivalent to the interface provided on 
	//the provider component (Payment.prov.IPaymentManager)

}