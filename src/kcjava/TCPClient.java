package kcjava;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;

public class TCPClient {
	public final String ServerIP = "86.236.227.45";
	
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
				
			
				new TCPClient(checkTest);
				new TCPClient(checkTest2);
				new TCPClient(checkTest3);
				new TCPClient(checkTest4);
				new TCPClient(checkTest5);
				
				System.out.println("Check-IN envoye");
	}
	public TCPClient(CheckTime check) throws Exception{

		this.check = check;
		
		Socket socketOfClient = null;
			
		try {
			// Tentative de connection au serveur
			socketOfClient = new Socket(ServerIP,8081);
			System.out.println("Connexion etablie avec le serveur "+ServerIP+" sur le port "+8081);
				
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