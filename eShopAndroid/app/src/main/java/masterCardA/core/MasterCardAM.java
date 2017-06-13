package masterCardA.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import eShop.App;
import masterCardA.prov.IManager;


/**
 * Created by COSMAPE-Feature IDE on 2016-jul-11.
 * Feature: MasterCardA
 * Component: MasterCardA
 *
 * This class contains the concrete methods of component 'MasterCardA'.
 */
public class MasterCardAM {
    private IManager manager;

    
    public MasterCardAM(IManager manager) {
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
		// Montando a URL
    	getManagers();
    	
    	boolean resu = false;
    	
    	try{
		String url = "http://" + App.servidor +  ":" + 8183 + "/" + "master" + "/disponibilidade";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// Tipo de M�todo
		con.setRequestMethod("GET");
		
		int responseCode = con.getResponseCode();
		System.out.println("\nEnviada a requisi��o 'GET' para a URL : " + url);
		System.out.println("C�digo de resposta : " + responseCode);
		
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
		resu = true;
		return resu;
    	}catch(Exception e){
    		return resu;
    	}
	}
    
    private String compra(float valor ,String nomeCartao , String numeroCartao,String validadeCartao,String cifCartao , int parcelas) throws IOException {
		// Montando a URL
		String url = "http://" + App.servidor +  ":" + 8183 + "/" + "master" + "/registraCompra";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// Tipo de M�todo
		con.setRequestMethod("POST");
		
		// Par�metros que o m�todo /registraCompra recebe
		con.setRequestProperty("numero", numeroCartao);
		con.setRequestProperty("codigo", cifCartao);
		con.setRequestProperty("nome", nomeCartao);
		con.setRequestProperty("validade", validadeCartao);
		con.setRequestProperty("valor", String.valueOf(valor));
		con.setRequestProperty("parcelas", String.valueOf(parcelas));	
		
		int responseCode = con.getResponseCode();
		System.out.println("\nEnviada a requisi��o 'POST' para a URL : " + url);
		System.out.println("C�digo de resposta : " + responseCode);

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
    
    public synchronized String pagarMaster(float valor ,String nomeCartao , String numeroCartao,String validadeCartao,String cifCartao , int parcelas){
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