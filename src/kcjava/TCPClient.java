package kcjava;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient implements Runnable {
	static Socket socket;
	static ObjectInputStream ois = null;
	static ObjectOutputStream oos = null;
	static Scanner console = null;
	static Boolean val = false;
 
	public void run() {
		try {
			System.out.println("Demande de connexion");
			socket = new Socket("127.0.0.1", 8085);
			System.out.println("Connexion établie avec le serveur");
			console = new Scanner(System.in);
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());

			CheckTime check = new CheckTime(42);
			oos.writeObject(check);

			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}