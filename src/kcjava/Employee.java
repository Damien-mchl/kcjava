package kcjava;
import java.time.*;
import static java.time.temporal.ChronoUnit.MINUTES;

import java.io.Serializable;

public class Employee implements Serializable{
	
	/***
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int MONDAY = 0;
	final int TUESDAY = 1;
	final int WEDNESDAY = 2;
	final int THURSDAY = 3;
	final int FRIDAY = 4;
	
	private	int id;
	private	String lastName;
	private	String firstName;
	private Planning planning;
	private long stockH; // Positif si il a fait des heures en trop
	private boolean checked = false; // pas encore pointé
	
	/**
	 * Constructeur de la classe Employee
	 * @param id identifiant de l'employé
	 * @param lastName Nom de famille
	 * @param firstName prénom
	 * @param planning son emploi du temps
	 * @param stockH son "stock" d'heure 
	 * 
	 * */
	public Employee(int id, String lastName, String firstName, Planning planning, long stockH) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.planning = planning;
		this.stockH = stockH;
	}
	/**
	 * Compare l'heure de pointage par rapport à l'heure prévue dans le planning
	 * 		  et ajoute l'excédant à la valeur stockH
	 * 
	 * @param checkTime l'heure du pointage
	 * 
	 * */
	public void planningCompare(CheckTime checkTime) {
		System.out.println("Comparaison du planning de "+this.firstName+" "+this.lastName);
		if (this.checked){ // Depart
			
			
			  
			int isSup = checkTime.getHeurePointage().compareTo(this.planning.getDeparturesByDay(getActualDayInt()));
			long between = checkTime.getHeurePointage().until(this.planning.getDeparturesByDay(getActualDayInt()), MINUTES);
			
			if(isSup > 0) { //Part plus tard
				this.stockH += between;
			}

			else if(isSup < 0) { //Part en avance
				this.stockH -= between;
			}
			
			this.checked = false;
		}else { // Arrivée
			
			
			  
			int isSup = checkTime.getHeurePointage().compareTo(this.planning.getArrivalsByDay(getActualDayInt()));
			long between = checkTime.getHeurePointage().until(this.planning.getArrivalsByDay(getActualDayInt()), MINUTES);
			
			if(isSup > 0) { // Arrive en avance
				this.stockH += between;
			}

			else if(isSup < 0) { // Arrive en retard
				this.stockH -= between;
			}
			
			this.checked = true;
		}
		System.out.println("Nouveau stockH = "+this.stockH);
	}
	/**
	 * Getter de id
	 * 
	 * @return id
	 * 
	 * */
	public int getId() {
		return id;
	}

	/**
	 * Setter de id
	 * 
	 * @param id id de l'employé
	 * 
	 * */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter de lastName
	 * 
	 * @return lastName
	 * 
	 * */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter de lastName
	 * 
	 * @param lastName nom de l'employe
	 * 
	 * */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter de firstName
	 * 
	 * @return firstName
	 * 
	 * */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter de firstName
	 * 
	 * @param firstName prenom de l'employe
	 * 
	 * */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter de Planning
	 * 
	 * @return planning
	 * 
	 * */
	public Planning getPlanning() {
		return planning;
	}

	/**
	 * Setter de Planning
	 * 
	 * @param planning planning de l'employe
	 * 
	 * */
	public void setPlanning(Planning planning) {
		this.planning = planning;
	}

	/**
	 * Getter de stockH
	 * 
	 * @return stockH
	 * 
	 * */
	public long getStockH() {
		return this.stockH;
	}
	
	/**
	 * Setter de stockH
	 * 
	 * @param stockH stock d'heures supplementaires de l'employe
	 * 
	 * */
	public void setStockH(long stockH) {
		this.stockH = stockH;
	}
	
	/**
	 * Getter du jour actuel (de 0 à 6)
	 * 
	 * @return entier representant le jour actuel de la semaine
	 * 
	 * */
	public int getActualDayInt() {
		LocalDate date = LocalDate.now();
		DayOfWeek day;
		day = date.getDayOfWeek();
		if(day.getValue()>5) {
			return 0;
		}
		return day.getValue()-1; 
	}
}