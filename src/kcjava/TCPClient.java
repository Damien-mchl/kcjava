package kcjava;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPClient {

 
	public static void main(String[] args) throws Exception{
		new TCPClient();
	}
	public TCPClient() throws Exception{

			System.out.println("Demande de connexion");
			Socket socket = new Socket("127.0.0.1", TCPServer.PORT);
			System.out.println("Connexion établie avec le serveur");

			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			

			CheckTime check = new CheckTime(42);
			oos.writeObject(check);

			CheckTime rep = (CheckTime)ois.readObject();
			
			System.out.println(rep.getIdentifiant());
			
			oos.close();
			socket.close();

	}
}
