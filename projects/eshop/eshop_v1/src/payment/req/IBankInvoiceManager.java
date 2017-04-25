package payment.req;

/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: Payment
 * Component: Payment
 * 
 * This interface is required by the 'Payment' component (Payment.req.IBankInvoiceManager). 
 * All signatures of business methods present here must be present in the 'IBankInvoiceManager' interface 
 * on the component origin (BankInvoice.prov.IBankInvoiceManager).
 */
public interface IBankInvoiceManager {
	String pagamentoBoleto(float valor);

	//TODO: Signatures of business methods

	//This interface must be equivalent to the interface provided on 
	//the provider component (BankInvoice.prov.IBankInvoiceManager)

}