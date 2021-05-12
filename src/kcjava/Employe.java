package kcjava;

public class Employe {
	
	private	int identifiant;
	private	String Nom;
	private	String Prenom;
	private Horaire Planning;	
	
	public Employe(int Id,String nom,String prenom,Horaire planning) {
		this.identifiant = Id;
		this.Nom=nom;
		this.Prenom=prenom;
		this.Planning = planning;
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
	
	
	
}
