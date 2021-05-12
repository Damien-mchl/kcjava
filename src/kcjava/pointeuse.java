package kcjava;
import java.time.*;

public class pointeuse {
	private LocalDateTime datePointage;
	private int identifiant;
	
	
	public pointeuse(LocalDateTime datePointage, int identifiant) {
		this.datePointage = datePointage;
		this.identifiant = identifiant;
	}
	public LocalDateTime getDatePointage() {
		return datePointage;
	}
	public void setDatePointage(LocalDateTime datePointage) {
		this.datePointage = datePointage;
	}
	public int getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	
	
}
