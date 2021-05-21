package kcjava;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPClient {
	public final String ServerIP = "127.0.0.1";
 
	private CheckTime check = null;
	
	private ObjectOutputStream outputStream = null;
	private ObjectInputStream inputStream = null;
	
	public static void main(String[] args) throws Exception{
		new TCPClient(new CheckTime(42));
	}
	public TCPClient(CheckTime check) throws Exception{

		this.check = check;
		
		Socket socketOfClient = null;
			
		try {
			// Tentative de connection au serveur
			socketOfClient = new Socket(ServerIP,TCPServer.PORT);
			System.out.println("Connexion etablie avec le serveur "+ServerIP+" sur le port "+TCPServer.PORT);
				
			this.outputStream = new ObjectOutputStream(socketOfClient.getOutputStream());
			this.inputStream = new ObjectInputStream(socketOfClient.getInputStream());
				
				
		}catch(IOException e) {
			System.out.println(e);
		}
		
		try {
			// Envoi de la CheckTime
			outputStream.writeObject(check);
			
			// Recuperation de la reponse serveur
			String repServeur = (String)inputStream.readObject();
			System.out.println(repServeur);
			
			outputStream.close();
			inputStream.close();
			socketOfClient.close();
				
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}
