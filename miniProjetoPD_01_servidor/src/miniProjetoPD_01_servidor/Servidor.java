package miniProjetoPD_01_servidor;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

import miniProjetoPD_01_response.ResponseObject;

public class Servidor implements Runnable{

	private Socket cliente;
	
	private ResponseObject response;

	public Servidor(Socket clienteConn) {
		this.cliente = clienteConn;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ServerSocket servidor = new ServerSocket(6500);

		System.out.println("Porta 6500 aberta!");

		System.out.println("Aguardando o recebimento de conexão do cliente...");   


		while (true) {
			Socket cliente = servidor.accept();
			Servidor serverTrhead = new Servidor(cliente);
			Thread t = new Thread(serverTrhead);
			t.start();
		}
	}	


	@Override
	public void run() {
		
		System.out.println("Nova conexao com o cliente " + this.cliente.getInetAddress().getHostAddress());

		DataInputStream in = null;
		try {
			in = new DataInputStream(this.cliente.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DataOutputStream out = null;
		try {
			out = new DataOutputStream(this.cliente.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String arquivo = new String();
		try {
			arquivo = "C:\\pd_files\\" + in.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		try {
			FileReader carregar = new FileReader(arquivo);
			
			if (Objects.isNull(carregar))
				this.response.setResposta("HTTP Status 400 - Bad Request");
			
			this.response.setResposta("HTTP Status 200 - OK");
			
			BufferedReader ler = new BufferedReader(carregar);

			String linha = ler.readLine();

			while(linha != null) {
				System.out.println(linha);
				linha = ler.readLine();
				if(linha!=null)
					out.writeUTF(linha);
			}

	
			//		out.writeUTF("Achou!");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

			try {
				this.cliente.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
