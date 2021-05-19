package kcjava;

import java.time.*;

public class Planning {
	private LocalTime[] arrivals;
	private LocalTime[] departures;
	
	public Planning() {
		this.arrivals = new LocalTime[5];
		this.departures = new LocalTime[5];
	}

	public Planning(LocalTime[] arrivals, LocalTime[] departures) {
		this.arrivals = arrivals;
		this.departures = departures;
	}
	
	
	public void setArrivalsDay(int jour, LocalTime heure) {
		this.arrivals[jour-1] = heure;
	}
	public void setDepartureDay(int jour, LocalTime heure) {
		this.departures[jour-1] = heure;
	}
	
	public LocalTime[] getArrivals() {
		return arrivals;
	}
	public void setArrivals(LocalTime[] arrivals) {
		this.arrivals = arrivals;
	}
	
	public LocalTime[] getDepartures() {
		return departures;
	}
	public void setDepartures(LocalTime[] departures) {
		this.departures = departures;
	}
	
	public LocalTime getArrivalsByDay(int day) {
		return this.arrivals[day];
	}
	
	public LocalTime getDeparturesByDay(int day) {
		return this.departures[day];
	}
}
