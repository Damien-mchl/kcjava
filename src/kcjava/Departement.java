package kcjava;

import java.util.*;

public class Departement {
	private String nom;
	private ArrayList<Employe> employes;
	
	public Departement(String nom) {
		this.nom = nom;
		this.employes = new ArrayList<Employe>();
	}
	
	public void ajouterEmploye(Employe e) {
		this.employes.add(e);
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(ArrayList<Employe> employes) {
		this.employes = employes;
	}
	
	
	
}
