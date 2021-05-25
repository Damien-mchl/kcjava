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
	
	private ObjectOutputStream outputStream = null;
	private ObjectInputStream inputStream = null;
	
	public static void main(String[] args) throws Exception{
		//Check-IN
				CheckTime checkTest = new CheckTime(LocalTime.now(), LocalDate.now(), 4);
				CheckTime checkTest2 = new CheckTime(LocalTime.now(), LocalDate.now(), 7);
				CheckTime checkTest3 = new CheckTime(LocalTime.now(), LocalDate.now(), 5);
				CheckTime checkTest4 = new CheckTime(LocalTime.now(), LocalDate.now(), 1);
				CheckTime checkTest5 = new CheckTime(LocalTime.now(), LocalDate.now(), 2);
				
				
				System.out.println("L'employee 4, 7, 5, 1, 2 ont check-IN");
				
			
				new TCPClient(checkTest, "localhost", 8081);
				new TCPClient(checkTest2, "localhost", 8081);
				new TCPClient(checkTest3, "localhost", 8081);
				new TCPClient(checkTest4, "localhost", 8081);
				new TCPClient(checkTest5, "localhost", 8081);
				
				System.out.println("Check-IN envoye");
	}
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
