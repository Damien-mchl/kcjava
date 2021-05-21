package kcjava;
import java.io.Serializable;
import java.time.*;

public class CheckTime implements Serializable{
	private LocalTime heurePointage;
	private LocalDate datePointage;
	private int identifiant;
	/*
	 * @brief  Constructeur de la classe CheckTime
	 * 
	 * @param	LocalTime heurePointage 
	 * @param	LocalDate datePointage
	 * @param	int identifiant identifiant de l'employ�
	 * */
	public CheckTime(LocalTime heurePointage, LocalDate datePointage, int identifiant) {
		this.heurePointage = roundTime(heurePointage);
		this.datePointage = datePointage;
		this.identifiant = identifiant;
	}
	

	/*
	 * @brief arrondi l'heure au quart d'heure le plus pr�s
	 * 
	 * @param LocalTime time
	 * 
	 * */
	public static LocalTime roundTime(LocalTime time) {
		int i=time.getMinute();
		//ça part à 0
		if(i<8) {
			time =time.withMinute(0);
		}
		//ça part à 15
		else if(i<23) {
			time =time.withMinute(15);
		}
		//ça part à 30
		else if(i<38) {
			time =time.withMinute(30);
		}
		//ça part à 45
		else if(i<53) {
			time =time.withMinute(45);
		}
		//ça part à 0(+1h)
		else {
			time =time.withMinute(0);
			time =time.plusHours(1);
		}
		
		
		return time;
		
	}
	
	
	/*
	 * @brief Constructeur de la classe CheckTime
	 * 
	 * @param int id identifiant employ�
	 * 
	 * */
	public CheckTime(int id) {
		
		this.identifiant = id;
	}


	
	

	/*
 	* @brief Getter de heurePointage

 	* @return LocalTime heurePointage
 	* 
 	* */
	public LocalTime getHeurePointage() {
		return heurePointage;
	}

	/*
	 * @brief setter de heurePointage

	 * @param LocalTime heurePointage
	 * 
	 * */
	public void setHeurePointage(LocalTime heurePointage) {
		this.heurePointage = heurePointage;
	}
	/*
	 * @brief Getter de datePointage

	 * @return LocalDate datePointage
	 * 
	 * */
	public LocalDate getDatePointage() {
		return datePointage;
	}
	/*
	 * @brief Setter de datePointage

	 * @param LocalDate datePointage
	 * 
	 * */
	public void setDatePointage(LocalDate datePointage) {
		this.datePointage = datePointage;
	}

	/*
	 * @brief Getter de identifiant

	 * @return int identifiant
	 * 
	 * */
	public int getIdentifiant() {
		return identifiant;
	}
	
	/*
	 * @brief Setter de identifiant

	 * @param int identifiant
	 * 
	 * */
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}


	
}
