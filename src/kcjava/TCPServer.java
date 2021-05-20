package kcjava;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPServer{
	 public static final int PORT = 3191;

	public static void main(String[] args) throws Exception{
		new TCPServer();
	}
	public TCPServer() throws Exception{
			ServerSocket socketserver = new ServerSocket(PORT);
			
			System.out.println("Le serveur est à l'écoute du port "+ PORT);
			Socket socket = socketserver.accept();
			
			System.out.println("Connexion client acceptée.");
			
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
 
			
			CheckTime check = (CheckTime)ois.readObject();
			
			System.out.println(check.getIdentifiant());
			
			CheckTime reponse = new CheckTime(17);
			oos.writeObject(reponse);
			
			socketserver.close();
	}
}
