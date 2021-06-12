package kcjava;


/**
 * lanceur du serveur
 */
public class MainServer {
	public static void main(String[] args) throws Exception{
		new TCPServer(new Company("KCORP"));
	}
}
