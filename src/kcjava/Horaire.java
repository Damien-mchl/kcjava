package kcjava;

import java.time.*;

public class Horaire {
	private LocalTime[] arrivees;
	private LocalTime[] departs;
	
	public Horaire(LocalTime[] arrivees, LocalTime[] departs) {
		this.arrivees = arrivees;
		this.departs = departs;
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
