package kcjava;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;



public class Company implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private ArrayList<Department> departments;
	private ArrayList<CheckTime> checks;
	
	/*
	 * @brief Constructeur d'une entreprise � partir d'un nom
	 * 
	 * */
	public Company(String name) {
		this.name = name;
		this.departments = new ArrayList<Department>();
		this.checks = new ArrayList<CheckTime>();
	}
	/*
	 * @brief Constructeur d'une entreprise � partir d'un nom et d'un nombre d'employ�s
	 * 
	 * */
	public Company(String name, int nombreEmployee) throws Exception {
		
		this.name = name;
		this.departments = new ArrayList<Department>();
		this.checks = new ArrayList<CheckTime>();
		
		// PLannings
		LocalTime start = LocalTime.of(7, 15);
		LocalTime end = LocalTime.of(18, 0);
		
		LocalTime[] starts = {start, start ,start ,start, start};
		LocalTime[] ends = {end, end ,end ,end, end};
		
		// Employees
		ArrayList<Employee> employees = new ArrayList<Employee>();
		for(int i = 0; i < nombreEmployee; i++) {
			Employee nouvelEmployee = new Employee(i, "prenomEmployee"+i,"nomEmployee"+i,new Planning(starts, ends), 0);
			employees.add(nouvelEmployee);
		}
		// Departments
		Department dep = new Department("Departement1");
		dep.setEmployes(employees);
		this.departments.add(dep);
		
		//Check-OUT
	}
	
	/*
	 * @brief Ajout d'un d�partement � l'entreprise
	 * 
	 * @param Departement le d�partement souhait�
	 * */
	public void addDepartment(Department dep) {
		if(!this.departments.contains(dep)) {
			this.departments.add(dep);
		}
	}
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
	/*
	 * @brief recherche un employ� dans l'entreprise
	 * 
	 * @param int l'id de l'employ�
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
	/*
	 * @brief modifie le planning d'un employ�
	 * 
	 * @param int l'id de l'employ�
	 * @param Planning le planning souhait�
	 * 
	 * */
	public void modifyEmployee(int id, Planning planning) {
		for(int i=0; i<this.departments.size();i++) {
			this.departments.get(i).modifyEmployeeDep(id,planning);
		}
	}
	/*
	 * @brief Ajout d'un employ� � un d�partement
	 * 
	 * @param Employee l'employ�
	 * @param String le d�partement
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
	/*
	 * @brief Getter de tout les employ�s de l'entreprise
	 * 
	 * @return ArrayList<Employee> la liste des employ�s de l'entreprise
	 * 
	 * */
	public ArrayList<Employee> getAllEmployees(){
		ArrayList<Employee> employees = new ArrayList<Employee>();
		for(int i = 0 ; i<this.departments.size(); i++) {
			employees.addAll(this.departments.get(i).getEmployees());
		}
		return employees;
	}
	/*
	 * @brief Getter du nom de l'entreprise
	 * 
	 * @return String le nom de l'entreprise
	 * 
	 * */
	public String getNom() {
		return name;
	}
	
	/*
	 * @brief Setter du nom de l'entreprise
	 * 
	 * @param String le nom de l'entreprise
	 * 
	 * */
	public void setNom(String name) {
		this.name = name;
	}
	
	/*
	 * @brief Getter des d�partements de l'entreprise
	 * 
	 * @return ArrayList<Department> la liste des d�partements
	 * 
	 * */
	public ArrayList<Department> getDepartements() {
		return departments;
	}
	
	/*
	 * @brief Setter des d�partements de l'entreprise
	 * 
	 * @param ArrayList<Department> la liste des d�partements
	 * 
	 * */
	public void setDepartements(ArrayList<Department> departments) {
		this.departments = departments;
	}
	/*
	 * @brief Getter des pointages de l'entreprise
	 * 
	 * @return ArrayList<CheckTime> la liste des pointages
	 * 
	 * */
	public ArrayList<CheckTime> getChecks() {
		return this.checks;
	}
	/*
	 * @brief Getter des pointages de l'entreprise du jour
	 * 
	 * @return ArrayList<CheckTime> la liste des pointages du jour
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
