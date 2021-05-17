package kcjava;
import java.time.*;

public class Employee {
	
	private	int identifiant;
	private	String nom;
	private	String prenom;
	private Planning planning;
	private LocalTime stockH;
	

	public Employee(int identifiant, String nom, String prenom, Planning planning, LocalTime stockH) {
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.planning = planning;
		this.stockH = stockH;
	}
	
		public int getIdentifiant() {
			return identifiant;
		}


		public void setIdentifiant(int identifiant) {
			this.identifiant = identifiant;
		}


		public String getNom() {
			return nom;
		}


		public void setNom(String nom) {
			this.nom = nom;
		}


		public String getPrenom() {
			return prenom;
		}


		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}


		public Planning getPlanning() {
			return planning;
		}


		public void setPlanning(Planning planning) {
			this.planning = planning;
		}


		public LocalTime getStockH() {
			return stockH;
		}


		public void setStockH(LocalTime stockH) {
			this.stockH = stockH;
		}

	
	
	
}


