package miniProjetoPD_01_cliente;

import java.util.HashMap;

public class URLCliente {

	private String fullUrl;

	private String host;
	private String port;
	private String file;

	public URLCliente(String urlCliente) {		

		//		
		setFullUrl(urlCliente);
	}

	public HashMap<String, String> infoUrl(){

		String[] entradaDoCliente = this.fullUrl.split(":");
		this.host = entradaDoCliente[0];

		String[] arquivo = entradaDoCliente[1].split("/");
		this.port = arquivo[0];
		this.file = arquivo[1];	

		HashMap<String, String> dadosUrl = new HashMap<String,String>();

		dadosUrl.put("host", this.host);
		dadosUrl.put("porta", this.port);
		dadosUrl.put("arquivo", this.file);

		return dadosUrl;

	}


	public boolean entradaUrl(String url) {

		if(url.matches("[a-z](.*)") || url.matches("[A-Z](.*)") )
			return false;

		return true;

	}

	public String getHost() {
		return host;
	}

	public String getPort() {
		return port;
	}

	public String getFile() {
		return file;
	}

	public String getFullUrl() {
		return fullUrl;
	}

	public void setFullUrl(String fullUrl) {
		this.fullUrl = fullUrl;
	}


	@Override
	public String toString() {
		return "URLCliente [host=" + host + ", port=" + port + ", file=" + file + "]";
	}


}
