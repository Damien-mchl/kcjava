package kcjava;
import java.time.*;

public class pointeuse {
	private LocalTime heurePointage;
	private LocalDate datePointage;
	private int identifiant;

	public pointeuse(LocalTime heurePointage, LocalDate datePointage, int identifiant) {
		
		int i=heurePointage.getMinute();
		//�a part � 0
		if(i<8) {
			heurePointage =heurePointage.withMinute(0);
		}
		//�a part � 15
		else if(i<23) {
			heurePointage =heurePointage.withMinute(15);
		}
		//�a part � 30
		else if(i<38) {
			heurePointage =heurePointage.withMinute(30);
		}
		//�a part � 45
		else if(i<53) {
			heurePointage =heurePointage.withMinute(45);
		}
		//�a part � 0(+1h)
		else {
			heurePointage =heurePointage.withMinute(0);
			heurePointage =heurePointage.plusHours(1);
		}
		
		this.heurePointage = heurePointage;
		
		
		
		this.datePointage = datePointage;
		this.identifiant = identifiant;
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
