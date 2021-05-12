package kcjava;
import java.time.*;

public class Employes {
	
	private	int identifiant;
	private	String nom;
	private	String prenom;
	private Horaire planning;
	private LocalTime stockH;
	
	
	
	
	public Employes(int identifiant, String nom, String prenom, Horaire planning, LocalTime stockH) {
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
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public Horaire getPlanning() {
		return Planning;
	}
	public void setPlanning(Horaire planning) {
		Planning = planning;
	}
	public LocalTime getStockH() {
		return stockH;
	}
	public void setStockH(LocalTime stockH) {
		this.stockH = stockH;
	}
	
	
	
}
