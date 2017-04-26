import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class testService {

	private static String urlDefault = "http://localhost:";
	private static int port = 8182;	
	
	public static void main(String[] args) {		
		testService teste = new testService();
		
		try {
			teste.getDisponibilidade("visa");
			teste.compra("visa");
			teste.getDisponibilidade("master");
			teste.compra("master");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getDisponibilidade(String bandeira) throws IOException {
		// Montando a URL
		String url = urlDefault + port + "/" + bandeira + "/disponibilidade";
		
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

		// Printa o resultado
		System.out.println(response.toString());
	}
	
	private void compra(String bandeira) throws IOException {
		// Montando a URL
		String url = urlDefault + port + "/" + bandeira + "/registraCompra";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// Tipo de Método
		con.setRequestMethod("POST");
		
		// Parâmetros que o método /registraCompra recebe
		con.setRequestProperty("numero", "4024007188523194");
		con.setRequestProperty("codigo", "757");
		con.setRequestProperty("nome", "THIAGO P MACHADO");
		con.setRequestProperty("validade", "10/2019");
		con.setRequestProperty("valor", "750");
		con.setRequestProperty("parcelas", "3");	
		
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
	}
}
