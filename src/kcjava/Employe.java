package kcjava;
import java.time.*;

public class Employe {
	
	private	int identifiant;
	private	String nom;
	private	String prenom;
	private Horaire planning;
	private LocalTime stockH;
	

	public Employe(int identifiant, String nom, String prenom, Horaire planning, LocalTime stockH) {
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


		public Horaire getPlanning() {
			return planning;
		}


		public void setPlanning(Horaire planning) {
			this.planning = planning;
		}


		public LocalTime getStockH() {
			return stockH;
		}


		public void setStockH(LocalTime stockH) {
			this.stockH = stockH;
		}

	
	
	
}


