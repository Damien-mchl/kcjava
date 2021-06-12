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
	 *  Constructeur d'une entreprise à partir d'un nom
	 * @param name nom de l'entreprise
	 * */
	public Company(String name) {
		this.name = name;
		this.departments = new ArrayList<Department>();
		this.checks = new ArrayList<CheckTime>();
	}
	
	/**
	 *  Ajout d'un département à l'entreprise
	 * 
	 * @param dep le département souhaité
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
	 *  recherche un employé dans l'entreprise
	 * 
	 * @param id l'id de l'employé
	 * 
	 * @return boolean vrai si l'employé est présent, faux sinon
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
	 *  modifie le planning d'un employé
	 * 
	 * @param id l'id de l'employé
	 * @param planning le planning souhaité
	 * 
	 * */
	public void modifyEmployee(int id, Planning planning) {
		for(int i=0; i<this.departments.size();i++) {
			this.departments.get(i).modifyEmployeeDep(id,planning);
		}
	}
	/**
	 *  Ajout d'un employé à un département
	 * 
	 * @param emp l'employé
	 * @param department le département
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
	 *  Getter de tout les employés de l'entreprise
	 * 
	 * @return la liste des employés de l'entreprise
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
	 *  Getter des départements de l'entreprise
	 * 
	 * @return la liste des départements
	 * 
	 * */
	public ArrayList<Department> getDepartements() {
		return departments;
	}
	
	/**
	 *  Setter des départements de l'entreprise
	 * 
	 * @param departments la liste des départements
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
