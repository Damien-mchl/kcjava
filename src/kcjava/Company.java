package kcjava;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;



public class Company {
	private String name;
	private ArrayList<Department> departments;
	
	public Company(String name) {
		this.name = name;
		this.departments = new ArrayList<Department>();
	}
	
	public Company(String name, int nombreEmployee) throws Exception {
		
		this.name = name;
		this.departments = new ArrayList<Department>();
		
		// PLannings
		LocalTime start = LocalTime.of(7, 15);
		LocalTime end = LocalTime.of(18, 0);
		
		LocalTime[] starts = {start, start ,start ,start, start};
		LocalTime[] ends = {end, end ,end ,end, end};
		
		// Employees
		ArrayList<Employee> employees = new ArrayList<Employee>();
		for(int i = 0; i < nombreEmployee; i++) {
			Employee nouvelEmployee = new Employee(i, "prenomEmployee"+i,"nomEmployee"+i,new Planning(starts, ends), 0);
			employees.add(nouvelEmployee);
		}
		// Departments
		Department dep = new Department("Departement1");
		dep.setEmployes(employees);
		this.departments.add(dep);
		
		
		new TCPServer(this);
		
		//Check-OUT
	}
	
	
	public String getNom() {
		return name;
	}
	public void setNom(String name) {
		this.name = name;
	}
	public ArrayList<Department> getDepartements() {
		return departments;
	}
	public void setDepartements(ArrayList<Department> departments) {
		this.departments = departments;
	}
	

	private class TCPServer{
		public static final int PORT = 3191;
		public Company comp = null;

		public TCPServer(Company comp) throws Exception{
				ServerSocket serverSocket = null;
				this.comp = comp;
				// Nombre de connections
				int clientNumber = 0;

				// Essaye d'ouvrir le serveur socket sur le port PORT
				try {
					serverSocket = new ServerSocket(PORT);
					System.out.println("Le serveur est à l'écoute du port "+ PORT);
				}catch(IOException e) {
					System.out.println(e);
				}
				try {
					while(true) {
						Socket socket = serverSocket.accept();
						System.out.println("Connexion client acceptée.");
						new ServiceThread(socket, clientNumber++).start();
					}
				}finally {
					serverSocket.close();
				}
		}
		private class ServiceThread extends Thread{
			private int clientNumber;
			private Socket socket;

			public ServiceThread(Socket socket, int clientNumber) {
				this.clientNumber = clientNumber;
				this.socket = socket;

				System.out.println("Nouvelle connection avec client numero " + this.clientNumber + " a " + socket);
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

						// COmparaison
						System.out.println("Comparaison planning de : "+check.getId());
						// Parcour des employee
						for (Employee emp : comp.getDepartements().get(0).getEmployees()) 
						{ 
						   if(emp.getId() == check.getId()) {
							   emp.planningCompare(check);
						   }
						}

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
}
