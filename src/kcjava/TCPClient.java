package kcjava;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;

public class TCPClient {
	public final String ServerIP;
 	public final int portClient;
	private CheckTime check = null;
	public final static String savePath = "saveClient";
	
	private ObjectOutputStream outputStream = null;
	private ObjectInputStream inputStream = null;
	
	
	public TCPClient(CheckTime check, String ip, int port) throws Exception{

		this.check = check;
		this.ServerIP = ip;
		this.portClient = port;
		
		Socket socketOfClient = null;
			
		try {
			// Tentative de connection au serveur
			socketOfClient = new Socket(ServerIP,portClient);
			System.out.println("Connexion etablie avec le serveur "+ServerIP+" sur le port "+portClient);
				
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
