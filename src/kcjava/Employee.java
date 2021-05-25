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
	
	/*
	 * @brief Constructeur de la classe Employee
	 * @param int id identifiant de l'employé
	 * @param String lastName Nom de famille
	 * @param String firstName prénom
	 * @param Planning planning son emploi du temps
	 * @param long stockH son "stock" d'heure 
	 * 
	 * */
	public Employee(int id, String lastName, String firstName, Planning planning, long stockH) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.planning = planning;
		this.stockH = stockH;
	}
	/*
	 * @brief Compare l'heure de pointage par rapport à l'heure prévue dans le planning
	 * 		  et ajoute l'excédant à la valeur stockH
	 * 
	 * @param CheckTime checkTime l'heure du pointage
	 * 
	 * */
	public void planningCompare(CheckTime checkTime) {
		System.out.println("Comparaison du planning de "+this.firstName+" "+this.lastName);
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
		System.out.println("Nouveau stockH = "+this.stockH);
	}
	/*
	 * @brief Getter de id
	 * 
	 * @return int id
	 * 
	 * */
	public int getId() {
		return id;
	}

	/*
	 * @brief Setter de id
	 * 
	 * @param int id
	 * 
	 * */
	public void setId(int id) {
		this.id = id;
	}

	/*
	 * @brief Getter de lastName
	 * 
	 * @return String lastName
	 * 
	 * */
	public String getLastName() {
		return lastName;
	}

	/*
	 * @brief Setter de lastName
	 * 
	 * @param String lastName
	 * 
	 * */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*
	 * @brief Getter de firstName
	 * 
	 * @return String firstName
	 * 
	 * */
	public String getFirstName() {
		return firstName;
	}

	/*
	 * @brief Setter de firstName
	 * 
	 * @param String firstName
	 * 
	 * */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/*
	 * @brief Getter de Planning
	 * 
	 * @return Planning planning
	 * 
	 * */
	public Planning getPlanning() {
		return planning;
	}

	/*
	 * @brief Setter de Planning
	 * 
	 * @param Planning planning
	 * 
	 * */
	public void setPlanning(Planning planning) {
		this.planning = planning;
	}

	/*
	 * @brief Getter de stockH
	 * 
	 * @return long stockH
	 * 
	 * */
	public long getStockH() {
		return stockH;
	}
	
	/*
	 * @brief Setter de stockH
	 * 
	 * @param long stockH
	 * 
	 * */
	public void setStockH(long stockH) {
		this.stockH = stockH;
	}
	
	/*
	 * @brief Getter du jour actuel (de 0 à 6)
	 * 
	 * @return LocalDate date
	 * 
	 * */
	public int getActualDayInt() {
		LocalDate date = LocalDate.now();
		DayOfWeek day;
		day = date.getDayOfWeek();
		return day.getValue() - 1; 
	}
}