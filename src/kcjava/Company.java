package kcjava;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;



public class Company implements Serializable{
	/***
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private ArrayList<Department> departments;
	private ArrayList<CheckTime> checks;
	
	/**
	 *  Constructeur d'une entreprise � partir d'un nom
	 * @param name nom de l'entreprise
	 * */
	public Company(String name) {
		this.name = name;
		this.departments = new ArrayList<Department>();
		this.checks = new ArrayList<CheckTime>();
	}
	
	/**
	 *  Ajout d'un d�partement � l'entreprise
	 * 
	 * @param dep le d�partement souhait�
	 */
	public void addDepartment(Department dep) {
		if(!this.departments.contains(dep)) {
			this.departments.add(dep);
		}
	}
	/**
	 * ajoute un pointage
	 * @param check pointage
	 */
	public void addCheck(CheckTime check) {
        if(!this.checks.contains(check)) {
            this.checks.add(check);
            for(Department d : departments) {
                for(Employee e : d.getEmployees()) {
                    if(e.getId() == check.getId()) {
                        e.planningCompare(check);
                    }
                }
            }
        }
    }
	/**
	 *  recherche un employ� dans l'entreprise
	 * 
	 * @param id l'id de l'employ�
	 * 
	 * @return boolean vrai si l'employ� est pr�sent, faux sinon
	 * */
	public boolean containsEmployee(int id) {
		boolean contains = false;
		for(int i=0; i<this.departments.size();i++) {
			if(this.departments.get(i).containsEmployeeDep(id)) {
				contains = true;
			}
		}
		return contains;
	}
	/**
	 *  modifie le planning d'un employ�
	 * 
	 * @param id l'id de l'employ�
	 * @param planning le planning souhait�
	 * 
	 * */
	public void modifyEmployee(int id, Planning planning) {
		for(int i=0; i<this.departments.size();i++) {
			this.departments.get(i).modifyEmployeeDep(id,planning);
		}
	}
	/**
	 *  Ajout d'un employ� � un d�partement
	 * 
	 * @param emp l'employ�
	 * @param department le d�partement
	 * 
	 * */
	public void addEmployee(Employee emp, String department) {
		boolean added = false;
		for(int i=0; i<this.departments.size();i++) {
			if(this.departments.get(i).getName().equals(department)) {
				this.departments.get(i).addEmployee(emp);
				added = true;
			}
		}
		if(!added) {
			Department dep = new Department(department);
			dep.addEmployee(emp);
			this.addDepartment(dep);
		}
	}
	/**
	 *  Getter de tout les employ�s de l'entreprise
	 * 
	 * @return la liste des employ�s de l'entreprise
	 * 
	 * */
	public ArrayList<Employee> getAllEmployees(){
		ArrayList<Employee> employees = new ArrayList<Employee>();
		for(int i = 0 ; i<this.departments.size(); i++) {
			employees.addAll(this.departments.get(i).getEmployees());
		}
		return employees;
	}
	/**
	 *  Getter du nom de l'entreprise
	 * 
	 * @return le nom de l'entreprise
	 * 
	 * */
	public String getNom() {
		return name;
	}
	
	/**
	 *  Setter du nom de l'entreprise
	 * 
	 * @param name le nom de l'entreprise
	 * 
	 * */
	public void setNom(String name) {
		this.name = name;
	}
	
	/**
	 *  Getter des d�partements de l'entreprise
	 * 
	 * @return la liste des d�partements
	 * 
	 * */
	public ArrayList<Department> getDepartements() {
		return departments;
	}
	
	/**
	 *  Setter des d�partements de l'entreprise
	 * 
	 * @param departments la liste des d�partements
	 * 
	 * */
	public void setDepartements(ArrayList<Department> departments) {
		this.departments = departments;
	}
	/**
	 *  Getter des pointages de l'entreprise
	 * 
	 * @return la liste des pointages
	 * 
	 * */
	public ArrayList<CheckTime> getChecks() {
		return this.checks;
	}
	/**
	 *  Getter des pointages de l'entreprise du jour
	 * 
	 * @return la liste des pointages du jour
	 * 
	 * */
	public ArrayList<CheckTime> getDailyChecks(){
		ArrayList<CheckTime> dailyChecks = new ArrayList<CheckTime>();
		LocalDate today = LocalDate.now();
		for(int i = 0 ; i<this.checks.size(); i++) {
			if(this.checks.get(i).getDatePointage().equals(today)) {
				dailyChecks.add(this.checks.get(i));
			}
		}
		return dailyChecks;
	}
	

}
