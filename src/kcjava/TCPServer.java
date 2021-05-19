package kcjava;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;

public class TCPServer implements Runnable {
	 
	static ServerSocket socketserver = null;
	static Socket socket;
	static ObjectInputStream ois = null;
	static ObjectOutputStream oos = null;

 
	public void run(){
		try {
			socketserver = new ServerSocket(8085);
			System.out.println("Le serveur est à l'écoute du port "+ socketserver.getLocalPort());
			socket = socketserver.accept();
			System.out.println("Connexion client acceptée.");
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
 
			
			CheckTime check;
			check = (CheckTime) ois.readObject();
			
			System.out.println("lu");
			System.out.println(check.getIdentifiant());
			
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
