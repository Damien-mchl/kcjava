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
	private boolean checked = false; // pas encore point�
	
	public Employee(int id, String lastName, String firstName, Planning planning, long stockH) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.planning = planning;
		this.stockH = stockH;
	}
	public void planningCompare(CheckTime checkTime) {
		System.out.println("Comparaison du planning de "+this.firstName+" "+this.lastName);
		if (this.checked){ // Depart
			
			
			  
			int isSup = checkTime.getHeurePointage().compareTo(this.planning.getDepartures(getActualDayInt()));
			long between = checkTime.getHeurePointage().until(this.planning.getDepartures(getActualDayInt()), MINUTES);
			
			if(isSup > 0) { // Part en avance
				this.stockH -= between;
			}

			else if(isSup < 0) { // Part en retard
				this.stockH += between;
			}
			
			this.checked = false;
		}else { // Arriv�e
			
			
			  
			int isSup = checkTime.getHeurePointage().compareTo(this.planning.getArrivals(getActualDayInt()));
			long between = checkTime.getHeurePointage().until(this.planning.getArrivals(getActualDayInt()), MINUTES);
			
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
	
	// Return le jour de la semaine de 0 � 6
	public int getActualDayInt() {
		LocalDate date = LocalDate.now();
		DayOfWeek day;
		day = date.getDayOfWeek();
		return day.getValue() - 1; 
	}
}