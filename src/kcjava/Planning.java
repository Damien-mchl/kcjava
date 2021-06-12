package kcjava;

import java.io.Serializable;
import java.time.*;

public class Planning implements Serializable{
	/***
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocalTime[] arrivals;
	private LocalTime[] departures;
	/**
	 * Constructeur par défaut de la classe Planning
	 * 
	 * */
	public Planning() {
		this.arrivals = new LocalTime[5];
		this.departures = new LocalTime[5];
	}
	/**
	 * Constructeur par défaut de la classe Planning
	 * 
	 * @param arrivals tableau des heures arrivés 
	 * @param departures tableau des heures départs
	 * */
	public Planning(LocalTime[] arrivals, LocalTime[] departures) {
		this.arrivals = arrivals;
		this.departures = departures;
	}
	
	/**
	 * Setter d'une heure d'arrivée d'un jour dans le planning
	 * 
	 * @param jour jour d'arrivée
	 * @param heure heure d'arrivée
	 * */
	public void setArrivalsDay(int jour, LocalTime heure) {
		this.arrivals[jour-1] = heure;
	}
	/**
	 * Setter d'une heure de depart d'un jour dans le planning
	 * 
	 * @param jour de depart
	 * @param heure heure d'arrivee
	 * */
	public void setDepartureDay(int jour, LocalTime heure) {
		this.departures[jour-1] = heure;
	}
	/**
	 * getter du planning des arrivées
	 * 
	 * @return arrivees
	 * */
	public LocalTime[] getArrivals() {
		return arrivals;
	}
	/**
	 * Setter du planning des arrivées
	 * 
	 * @param arrivals arrivees
	 * */
	public void setArrivals(LocalTime[] arrivals) {
		this.arrivals = arrivals;
	}
	/**
	 * getter du planning des départs
	 * 
	 * @return departures departs
	 * */
	public LocalTime[] getDepartures() {
		return departures;
	}
	/**
	 * Setter du planning des départs
	 * 
	 * @param departures departs
	 * */
	public void setDepartures(LocalTime[] departures) {
		this.departures = departures;
	}
	/**
	 * getter du planning des départ du jour
	 * 
	 * @param day jour de depart
	 * @return arrivals arrivees du jour
	 * */
	public LocalTime getArrivalsByDay(int day) {
		return this.arrivals[day];
	}
	/**
	 * getter du planning des arrivées du jour
	 * 
	 * @param day jour souhaite
	 * @return departs du jour
	 * */
	public LocalTime getDeparturesByDay(int day) {
		return this.departures[day];
	}
}
