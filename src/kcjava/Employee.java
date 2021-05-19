package kcjava;
import java.time.*;
import static java.time.temporal.ChronoUnit.MINUTES;

public class Employee{
	
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
	
	public Employee(int id, String lastName, String firstName, Planning planning, long stockH) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.planning = planning;
		this.stockH = stockH;
	}
	public void planningCompare(CheckTime checkTime) {
		if (this.checked){ // Depart
			
			
			  
			int isSup = checkTime.getHeurePointage().compareTo(this.planning.getDeparturesByDay(getActualDayInt()));
			long between = checkTime.getHeurePointage().until(this.planning.getDeparturesByDay(getActualDayInt()), MINUTES);
			
			if(isSup > 0) { // Part en avance
				this.stockH -= between;
			}

			else if(isSup < 0) { // Part en retard
				this.stockH += between;
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
	}
	
	public int getIdentifiant() {
		return id;
	}


	public void setIdentifiant(int id) {
		this.id = id;
	}


	public String getNom() {
		return lastName;
	}


	public void setNom(String lastName) {
		this.lastName = lastName;
	}


	public String getPrenom() {
		return firstName;
	}


	public void setPrenom(String firstName) {
		this.firstName = firstName;
	}


	public Planning getPlanning() {
		return planning;
	}


	public void setPlanning(Planning planning) {
		this.planning = planning;
	}


	public long getStockH() {
		return stockH;
	}


	public void setStockH(long stockH) {
		this.stockH = stockH;
	}
	
	// Return le jour de la semaine de 0 à 6
	public int getActualDayInt() {
		LocalDate date = LocalDate.now();
		DayOfWeek day;
		day = date.getDayOfWeek();
		return day.getValue() - 1; 
	}
}


