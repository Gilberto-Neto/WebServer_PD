package miniProjetoPD_01_servidor;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			ServerSocket ss = new ServerSocket(6500);
			Socket s = ss.accept();
			
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			
//			out.writeUTF(in.readUTF() + "Veio!");
			
			String arquivo = "C:\\Users\\alexs\\eclipse-workspace\\miniProjetoPD\\miniProjetoPD_01_servidor\\src\\miniProjetoPD_01_servidor\\" + in.readUTF();
try {
			
			FileReader carregar = new FileReader(arquivo);
			BufferedReader ler = new BufferedReader(carregar);
						
			String linha = ler.readLine();
			
			while(linha != null) {
				System.out.println(linha);
				linha = ler.readLine();
				if(linha!=null)
					out.writeUTF(linha);
			}
			
			out.writeUTF("Fim");
			 
//			out.writeUTF("Achou!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			s.close();
			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}

}
