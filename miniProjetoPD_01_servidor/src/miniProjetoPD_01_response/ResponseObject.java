package miniProjetoPD_01_response;

import java.io.Serializable;

public class ResponseObject implements Serializable {

	private static final long serialVersionUID = -1960324017687069550L;

	private String statusCode;
	
	private String resposta;
	
	public ResponseObject() {}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	
	

}
