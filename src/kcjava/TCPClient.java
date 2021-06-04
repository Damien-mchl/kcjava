package kcjava;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class TCPClient {
	public final String ServerIP;
 	public final int portClient;
	private CheckTime check = null;
	public final static String savePath = "saves/saveClient.ser";
	
	private ObjectOutputStream outputStream = null;
	private ObjectInputStream inputStream = null;
	
	
	public TCPClient(CheckTime check, String ip, int port) throws Exception{

		this.check = check;
		this.ServerIP = ip;
		this.portClient = port;
		
		Socket socketOfClient = null;
			
		try {
			// Tentative de connection au serveur
			socketOfClient = new Socket(this.ServerIP,this.portClient);
			socketOfClient.setSoTimeout(5000); // Au bout de 5 sec on considere que la requete a echouee
			System.out.println("Connexion etablie avec le serveur "+this.ServerIP+" sur le port "+this.portClient);
				
			this.outputStream = new ObjectOutputStream(socketOfClient.getOutputStream());
			this.inputStream = new ObjectInputStream(socketOfClient.getInputStream());
				
				
		}catch(java.net.SocketTimeoutException e) {
			//Si la connexion echoue
			// On charge les checks deja existant et on ajoute celui ci, puis on recreer le fichier
			ArrayList<CheckTime> checks;
			File f = new File(savePath);
			if(f.exists()) {
				checks = Sauvegarde.charger(savePath);
				System.out.println("Check loaded");
			}else {
				checks = new ArrayList<CheckTime>();
				System.out.println("No check to load");
			}
			checks.add(this.check);
			Sauvegarde.sauvegarder(checks, savePath);
			System.out.println("Check saved");
			
		}catch(java.net.ConnectException e){ 	
			//Si la connexion echoue
			// On charge les checks deja existant et on ajoute celui ci, puis on recreer le fichier
			ArrayList<CheckTime> checks;
			File f = new File(savePath);
			if(f.exists()) {
				checks = Sauvegarde.charger(savePath);
				System.out.println("Check loaded");
			}else {
				checks = new ArrayList<CheckTime>();
				System.out.println("No check to load");
			}
			checks.add(this.check);
			Sauvegarde.sauvegarder(checks, savePath);
			System.out.println("Check saved");
		}catch(java.net.UnknownHostException e) {
			//Si la connexion echoue
			// On charge les checks deja existant et on ajoute celui ci, puis on recreer le fichier
			ArrayList<CheckTime> checks;
			File f = new File(savePath);
			if(f.exists()) {
				checks = Sauvegarde.charger(savePath);
				System.out.println("Check loaded");
			}else {
				checks = new ArrayList<CheckTime>();
				System.out.println("No check to load");
			}
			checks.add(this.check);
			Sauvegarde.sauvegarder(checks, savePath);
			System.out.println("Check saved");
		}
		
		try {
			// Envoi de la CheckTime
			outputStream.writeObject(this.check);
			
			// Recuperation de la reponse serveur
			String repServeur = (String)inputStream.readObject();
			System.out.println(repServeur);
			
			// Envoi de ce qu'il ya dans la file d'attente sauvegardee
			File f = new File(savePath);
			ArrayList<CheckTime> waitingChecks;
			if(f.exists()) {
				waitingChecks = Sauvegarde.charger(savePath);
				System.out.println("Waiting Check loaded");
				
				for(CheckTime c : waitingChecks) {
					// Envoi de la CheckTime
					outputStream.writeObject(c);
					
					// Recuperation de la reponse serveur
					String rep = (String)inputStream.readObject();
					System.out.println(rep);
				}
			}
			f.delete();
			outputStream.close();
			inputStream.close();
			socketOfClient.close();
				
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}
