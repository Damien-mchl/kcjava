package kcjava;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import controller.Controller;
import controller.ServerController;
import model.Model;
import model.ServerModel;
import view.ServerView;
import view.View;


public class TCPServer{
	public static final int PORT = 3191;
	private Company company;
	public static ServerController controller;
	
	public static String savePath;
	
	public TCPServer(Company company) throws Exception{
			// Deduction du fichier de sauvegarde associé
			savePath = "saves/"+company.getNom()+".ser";
			File f = new File(savePath);
			if(f.exists())
				this.company = Sauvegarde.chargerCompany(savePath);
			else
				this.company = company;
			
			ServerSocket serverSocket = null;
			
			// Nombre de connections
			int clientNumber = 0;
			
			// Essaye d'ouvrir le serveur socket sur le port PORT
			try {
				serverSocket = new ServerSocket(PORT);
				System.out.println("Le serveur est a  l'ecoute du port "+ PORT);
			}catch(IOException e) {
				System.out.println(e);
			}
			try {
				ServerView view = new ServerView("Time tracker emulator - V1.4 - Server");
				ServerModel model = new ServerModel(this.company);
				controller = new ServerController(model,view);
				controller.initController();
				while(true) {
					Socket socket = serverSocket.accept();
					System.out.println("Connexion client acceptee.");
					new ServiceThread(socket, clientNumber++).start();
				}
			}finally {
				serverSocket.close();
			}
	}
	public static void refreshTable() {
		controller.refreshCheckTables();
	}
	
	private class ServiceThread extends Thread{
		private int clientNumber;
		private Socket socket;
		
		public ServiceThread(Socket socket, int clientNumber) {
			this.clientNumber = clientNumber;
			this.socket = socket;
			
			System.out.println("New connection with " + this.clientNumber + " at " + socket);
		}
		@Override
		public void run() {
			try {
				ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
				
				while(true) {
					// On recup le checkTime envoye par la pointeuse
					CheckTime check = (CheckTime)inputStream.readObject();
					System.out.println("Donnees recup sur employe nb : "+check.getId());
					company.addCheck(check);
					// On refresh l'affichage
					TCPServer.refreshTable();
					// On repond a la poiteuse
					String rep = new String("Bien recu");
					outputStream.writeObject(rep);
				}
				
			}catch(IOException e) {
				System.out.println(e);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
