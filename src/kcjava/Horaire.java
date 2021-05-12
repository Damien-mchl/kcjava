package kcjava;

import java.time.*;

public class Horaire {
	private LocalTime[] arrivees;
	private LocalTime[] departs;
	
	public Horaire() {
		this.arrivees = new LocalTime[5];
		this.departs = new LocalTime[5];
	}

	public Horaire(LocalTime[] arrivees, LocalTime[] departs) {
		this.arrivees = arrivees;
		this.departs = departs;
	}
	
	
	public void setArriveeJour(int jour, LocalTime heure) {
		this.arrivees[jour-1] = heure;
	}
	public void setDepartJour(int jour, LocalTime heure) {
		this.departs[jour-1] = heure;
	}
	
	public LocalTime[] getArrivees() {
		return arrivees;
	}
	public void setArrivees(LocalTime[] arrivees) {
		this.arrivees = arrivees;
	}
	public LocalTime[] getDeparts() {
		return departs;
	}
	public void setDeparts(LocalTime[] departs) {
		this.departs = departs;
	}
	
	
}
