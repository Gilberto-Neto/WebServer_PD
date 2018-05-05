package miniProjetoPD_01_servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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
			
			out.writeUTF(in.readUTF() + "Veio!");
		
			s.close();
			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
