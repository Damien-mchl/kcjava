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
	 * @brief Constructeur par d�faut de la classe Planning
	 * 
	 * */
	public Planning() {
		this.arrivals = new LocalTime[5];
		this.departures = new LocalTime[5];
	}
	/*
	 * @brief Constructeur par d�faut de la classe Planning
	 * 
	 * @param LocalTime[] arrivals tableau des heures arriv�s 
	 * @param LocalTime[] departures tableau des heures d�parts
	 * */
	public Planning(LocalTime[] arrivals, LocalTime[] departures) {
		this.arrivals = arrivals;
		this.departures = departures;
	}
	
	/*
	 * @brief Setter d'une heure d'arriv�e d'un jour dans le planning
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
	 * @brief getter du planning des arriv�es
	 * 
	 * @return LocalTime[] arrivals
	 * */
	public LocalTime[] getArrivals() {
		return arrivals;
	}
	/*
	 * @brief Setter du planning des arriv�es
	 * 
	 * @param LocalTime[] arrivals
	 * */
	public void setArrivals(LocalTime[] arrivals) {
		this.arrivals = arrivals;
	}
	/*
	 * @brief getter du planning des d�parts
	 * 
	 * @return LocalTime[] departures
	 * */
	public LocalTime[] getDepartures() {
		return departures;
	}
	/*
	 * @brief Setter du planning des d�parts
	 * 
	 * @param LocalTime[] departures
	 * */
	public void setDepartures(LocalTime[] departures) {
		this.departures = departures;
	}
	/*
	 * @brief getter du planning des d�part du jour
	 * 
	 * @param int day
	 * @return LocalTime arrivals
	 * */
	public LocalTime getArrivalsByDay(int day) {
		return this.arrivals[day];
	}
	/*
	 * @brief getter du planning des arriv�es du jour
	 * 
	 * @param int day
	 * @return LocalTime departures
	 * */
	public LocalTime getDeparturesByDay(int day) {
		return this.departures[day];
	}
}
