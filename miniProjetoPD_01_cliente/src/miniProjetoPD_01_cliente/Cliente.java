package miniProjetoPD_01_cliente;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.server.SocketSecurityException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Socket socket;
		Scanner sc = new Scanner(System.in);
		
		URLCliente input = new URLCliente(sc.nextLine());
		
		System.out.println(input.toString());
		
//		String s = "192.168.1.212:6500/index.html";
//		String s = sc.nextLine();
//		String[] entradaDoCliente = s.split(":");
//		String host = entradaDoCliente[0];
//		String[] arquivo = entradaDoCliente[1].split("/");
//		String porta = arquivo[0];
//		String file = arquivo[1];
		
		/*try {
			
			FileReader carregar = new FileReader("C:\\Users\\alexs\\eclipse-workspace\\miniProjetoPD\\miniProjetoPD_01_cliente\\src\\miniProjetoPD_01_cliente\\Arquivo.txt");
			BufferedReader ler = new BufferedReader(carregar);
						
			String linha = ler.readLine();
			
			while(linha != null) {
				System.out.println(linha);
				linha = ler.readLine();
			}
			 
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		try {
			socket = new Socket(input.getHost(),Integer.parseInt(input.getPort()));
			
			//escrita no servidor
	        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

	        //leitura do servidor
	        DataInputStream in = new DataInputStream(socket.getInputStream());
	        
	        out.writeUTF(input.getFile());
	        
	        System.out.println(in.readUTF());
	        
	        socket.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	        						
				
	}

}
