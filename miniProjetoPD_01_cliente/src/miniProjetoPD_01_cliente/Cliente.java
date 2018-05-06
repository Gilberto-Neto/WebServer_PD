package miniProjetoPD_01_cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
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
		
		Socket socket;
		Scanner sc = new Scanner(System.in);
		
		URLCliente input = new URLCliente(sc.nextLine());
		
		System.out.println(input.toString());
		
		socket = new Socket(input.getHost(),Integer.parseInt(input.getPort()));
		
		Cliente cliente = new Cliente (socket, input);
		
		Thread threadCliente = new Thread(cliente);
		
		threadCliente.start();
				
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

	        
	        out.writeUTF(this.clienteInput.getFile());
	        
	        while(in.readUTF()!="Fim") {
	        	System.out.println(in.readUTF());
	        }
	        
	        this.cliente.close();
		
		
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} 

	}
}