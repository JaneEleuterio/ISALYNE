package visaC.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import visaC.prov.IManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: VisaC
 * Component: VisaC
 *
 * This class contains the concrete methods of component 'VisaC'.
 */
public class VisaCM {
    private IManager manager;

    
    public VisaCM(IManager manager) {
        this.manager = manager;
    }

    private void getManagers() {
	
        
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
    public synchronized boolean getDisponibilidade() {
    	getManagers();
		// Montando a URL
    	boolean resu = false;
    	try{
    	String url = "http://localhost:" + 8182 + "/" + "visa" + "/disponibilidade";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// Tipo de Método
		con.setRequestMethod("GET");
		
		int responseCode = con.getResponseCode();
		System.out.println("\nEnviada a requisição 'GET' para a URL : " + url);
		System.out.println("Código de resposta : " + responseCode);
		
		// Pega o resuldado e o formata para printar
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		System.out.println(response.toString());
		resu = true;
		return resu;
    	}catch(Exception e){
    		return resu;
    	}

		// Printa o resultado
		
	}
    
    private String compra(float valor ,String nomeCartao , String numeroCartao,String validadeCartao,String cifCartao , int parcelas) throws IOException {
		// Montando a URL
		String url = "http://localhost:" + 8182 + "/" + "visa" + "/registraCompra";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// Tipo de Método
		con.setRequestMethod("POST");
		
		// Parâmetros que o método /registraCompra recebe
		con.setRequestProperty("numero", numeroCartao);
		con.setRequestProperty("codigo", cifCartao);
		con.setRequestProperty("nome", nomeCartao);
		con.setRequestProperty("validade", validadeCartao);
		con.setRequestProperty("valor", String.valueOf(valor));
		con.setRequestProperty("parcelas", String.valueOf(parcelas));	
		
		int responseCode = con.getResponseCode();
		System.out.println("\nEnviada a requisição 'POST' para a URL : " + url);
		System.out.println("Código de resposta : " + responseCode);

		// Pega o resuldado e o formata para printar
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();		
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// Printa o resultado
		System.out.println(response.toString());
		return response.toString();
	}
    public synchronized String pagarVisa(float valor,String nomeCartao,String numeroCartao,String validadeCartao,String cifCartao,int parcelas){
    	getManagers();
    	String resu = null;
    	
    	try{  	
    	resu = compra(valor, nomeCartao, numeroCartao, validadeCartao, cifCartao, parcelas);    	
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return resu;
    	
    }
}