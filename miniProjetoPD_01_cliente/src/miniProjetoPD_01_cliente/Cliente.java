package miniProjetoPD_01_cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Scanner;

public class Cliente implements Runnable {

	private Socket cliente;

	private URLCliente clienteInput;

	public Cliente(Socket cliente, URLCliente input){
		this.cliente = cliente;
		this.clienteInput = input;
	}

	public static void main(String[] args) throws NumberFormatException, UnknownHostException, IOException {
		// TODO Auto-generated method stub

		Socket socket = null;
		Scanner sc = new Scanner(System.in);

		URLCliente input = new URLCliente(sc.nextLine());
<<<<<<< HEAD
		
//		System.out.println(input.toString());
		
		try {
			socket = new Socket(input.getHost(),Integer.parseInt(input.getPort()));
			Cliente cliente = new Cliente (socket, input);
			Thread threadCliente = new Thread(cliente);
			threadCliente.start();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro ao conectar!");
		}						
=======

		System.out.println(input.toString());

		HashMap<String, String> dadosUrl = input.infoUrl();

		String host = dadosUrl.get("host");
		String porta = dadosUrl.get("porta");

		while(input.entradaUrl(host) == false) {
			System.out.println("Digite um ip válido. Ex: 0.0.0.0:porta/arquivo");	
		}


		try {
			socket = new Socket(host,Integer.parseInt(porta));

			Cliente cliente = new Cliente (socket, input);

			Thread threadCliente = new Thread(cliente);

			threadCliente.start();
		} catch (Exception e) {
			System.out.println("Erro ao conectar com o servidor!");
		}

>>>>>>> 30217a0c4da393c3a8de12173fed4ed64f082ec8
	}

	@Override
	public void run() {

		try {

			System.out.println("Conexão estabelecida com o servidor. ");

			//escrita no servidor
			DataOutputStream out = new DataOutputStream(this.cliente.getOutputStream());

			//leitura do servidor
			DataInputStream in = new DataInputStream(this.cliente.getInputStream());

			System.out.println("Procurando pelo arquivo solicitado...");
<<<<<<< HEAD
	        
	        out.writeUTF(this.clienteInput.getFile());	        
	        
	        
	        System.out.println(in.readUTF());	        
	        	        
	        this.cliente.close();
				
=======

			out.writeUTF(this.clienteInput.getFile());	        


			System.out.println(in.readUTF());	        

			this.cliente.close();

>>>>>>> 30217a0c4da393c3a8de12173fed4ed64f082ec8
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
}