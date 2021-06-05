package kcjava;

import java.io.Serializable;
import java.time.*;

public class Planning implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocalTime[] arrivals;
	private LocalTime[] departures;
	/*
	 * @brief Constructeur par défaut de la classe Planning
	 * 
	 * */
	public Planning() {
		this.arrivals = new LocalTime[5];
		this.departures = new LocalTime[5];
	}
	/*
	 * @brief Constructeur par défaut de la classe Planning
	 * 
	 * @param LocalTime[] arrivals tableau des heures arrivés 
	 * @param LocalTime[] departures tableau des heures départs
	 * */
	public Planning(LocalTime[] arrivals, LocalTime[] departures) {
		this.arrivals = arrivals;
		this.departures = departures;
	}
	
	/*
	 * @brief Setter d'une heure d'arrivée d'un jour dans le planning
	 * 
	 * @param int jour
	 * @param LocalTime heure
	 * */
	public void setArrivalsDay(int jour, LocalTime heure) {
		this.arrivals[jour-1] = heure;
	}
	/*
	 * @brief Setter d'une heure de depart d'un jour dans le planning
	 * 
	 * @param int jour
	 * @param LocalTime heure
	 * */
	public void setDepartureDay(int jour, LocalTime heure) {
		this.departures[jour-1] = heure;
	}
	/*
	 * @brief getter du planning des arrivées
	 * 
	 * @return LocalTime[] arrivals
	 * */
	public LocalTime[] getArrivals() {
		return arrivals;
	}
	/*
	 * @brief Setter du planning des arrivées
	 * 
	 * @param LocalTime[] arrivals
	 * */
	public void setArrivals(LocalTime[] arrivals) {
		this.arrivals = arrivals;
	}
	/*
	 * @brief getter du planning des départs
	 * 
	 * @return LocalTime[] departures
	 * */
	public LocalTime[] getDepartures() {
		return departures;
	}
	/*
	 * @brief Setter du planning des départs
	 * 
	 * @param LocalTime[] departures
	 * */
	public void setDepartures(LocalTime[] departures) {
		this.departures = departures;
	}
	/*
	 * @brief getter du planning des départ du jour
	 * 
	 * @param int day
	 * @return LocalTime arrivals
	 * */
	public LocalTime getArrivalsByDay(int day) {
		return this.arrivals[day];
	}
	/*
	 * @brief getter du planning des arrivées du jour
	 * 
	 * @param int day
	 * @return LocalTime departures
	 * */
	public LocalTime getDeparturesByDay(int day) {
		return this.departures[day];
	}
}
