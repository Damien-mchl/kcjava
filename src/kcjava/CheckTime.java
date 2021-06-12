package kcjava;
import java.io.Serializable;
import java.time.*;

public class CheckTime implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocalTime heurePointage;
	private LocalDate datePointage;
	private int identifiant;
	/**
	 *  Constructeur de la classe CheckTime
	 * 
	 * @param	heurePointage heure de pointage
	 * @param	datePointage date de pointage
	 * @param	identifiant identifiant de l'employé
	 * */
	public CheckTime(LocalTime heurePointage, LocalDate datePointage, int identifiant) {
		this.heurePointage = roundTime(heurePointage);
		this.datePointage = datePointage;
		this.identifiant = identifiant;
	}
	

	/**
	 * arrondi l'heure au quart d'heure le plus près
	 * 
	 * @param time heure
	 * @return heure arrondie
	 * */
	public static LocalTime roundTime(LocalTime time) {
		int i=time.getMinute();
		//Ã§a part Ã  0
		if(i<8) {
			time =time.withMinute(0);
		}
		//Ã§a part Ã  15
		else if(i<23) {
			time =time.withMinute(15);
		}
		//Ã§a part Ã  30
		else if(i<38) {
			time =time.withMinute(30);
		}
		//Ã§a part Ã  45
		else if(i<53) {
			time =time.withMinute(45);
		}
		//Ã§a part Ã  0(+1h)
		else {
			time =time.withMinute(0);
			time =time.plusHours(1);
		}
		
		
		return time;
		
	}
	
	
	/**
	 * Constructeur de la classe CheckTime
	 * 
	 * @param id identifiant de l'employé
	 * 
	 * */
	public CheckTime(int id) {
		
		this.identifiant = id;
	}


	
	

	/**
 	* Getter de heurePointage

 	* @return heurePointage heure de pointage
 	* 
 	* */
	public LocalTime getHeurePointage() {
		return heurePointage;
	}

	/**
	 * setter de heurePointage

	 * @param heurePointage heure de pointage
	 * 
	 * */
	public void setHeurePointage(LocalTime heurePointage) {
		this.heurePointage = heurePointage;
	}
	/**
	 * Getter de datePointage

	 * @return datePointage date de pointage
	 * 
	 * */
	public LocalDate getDatePointage() {
		return datePointage;
	}
	/**
	 * Setter de datePointage

	 * @param datePointage date de pointage
	 * 
	 * */
	public void setDatePointage(LocalDate datePointage) {
		this.datePointage = datePointage;
	}

	/**
	 * Getter de identifiant

	 * @return identifiant indentifiant de l'employé
	 * 
	 * */
	public int getId() {
		return identifiant;
	}
	
	/**
	 * Setter de identifiant

	 * @param identifiant indentifiant de l'employé
	 * 
	 * */
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	/**
	 * Récupération d'une heure en String

	 * @return chaine representant l'heure de pointage
	 * 
	 * */
	public String hourToString() {
		return this.heurePointage.toString().substring(0, 5);
	}
	
	/**
	 * Récupération d'une date en String

	 * @return chaine representant la date de pointage
	 * 
	 * */
	public String dateToString() {
		return this.datePointage.toString();
	}

	
}
