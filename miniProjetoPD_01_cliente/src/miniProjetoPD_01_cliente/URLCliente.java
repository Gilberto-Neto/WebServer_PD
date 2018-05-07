package miniProjetoPD_01_cliente;

public class URLCliente {
	private String host;
	private String port;
	private String file;

	public URLCliente(String urlCliente) {
		try {
			String[] entradaDoCliente = urlCliente.split(":");
			this.host = entradaDoCliente[0];
			String[] arquivo = entradaDoCliente[1].split("/");
			this.port = arquivo[0];
			this.file = arquivo[1];
		} catch (Exception e) {
			System.out.println("Entrada incorreta");
		}				
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

	@Override
	public String toString() {
		return "URLCliente [host=" + host + ", port=" + port + ", file=" + file + "]";
	}
		
}
