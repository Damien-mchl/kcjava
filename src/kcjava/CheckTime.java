package kcjava;
import java.io.Serializable;
import java.time.*;

public class CheckTime implements Serializable{
	private LocalTime heurePointage;
	private LocalDate datePointage;
	private int identifiant;

	public CheckTime(LocalTime heurePointage, LocalDate datePointage, int identifiant) {
		this.heurePointage = roundTime(heurePointage);
		this.datePointage = datePointage;
		this.identifiant = identifiant;
	}
	
	

	public CheckTime(int id) {
		this.identifiant = id;
	}

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

	public LocalTime getHeurePointage() {
		return heurePointage;
	}

	public void setHeurePointage(LocalTime heurePointage) {
		this.heurePointage = heurePointage;
	}

	public LocalDate getDatePointage() {
		return datePointage;
	}

	public void setDatePointage(LocalDate datePointage) {
		this.datePointage = datePointage;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}


	
}
