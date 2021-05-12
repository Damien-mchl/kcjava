package kcjava;

import java.util.*;

public class Entreprise {
	private String nom;
	private ArrayList<Departement> departements;
	
	public Entreprise(String nom) {
		this.nom = nom;
		this.departements = new ArrayList<Departement>();
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public ArrayList<Departement> getDepartements() {
		return departements;
	}
	public void setDepartements(ArrayList<Departement> departements) {
		this.departements = departements;
	}
	
	
}
