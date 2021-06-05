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
	
	public Company(String name) {
		this.name = name;
		this.departments = new ArrayList<Department>();
		this.checks = new ArrayList<CheckTime>();
	}
	
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
	
	
	public void addDepartment(Department dep) {
		if(!this.departments.contains(dep)) {
			this.departments.add(dep);
		}
	}
	public void addCheck(CheckTime check) {
		if(!this.checks.contains(check)) {
			this.checks.add(check);
		}
	}
	
	public boolean containsEmployee(int id) {
		boolean contains = false;
		for(int i=0; i<this.departments.size();i++) {
			if(this.departments.get(i).containsEmployeeDep(id)) {
				contains = true;
			}
		}
		return contains;
	}
	
	public void modifyEmployee(int id, Planning planning) {
		for(int i=0; i<this.departments.size();i++) {
			this.departments.get(i).modifyEmployeeDep(id,planning);
		}
	}
	
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
	
	public ArrayList<Employee> getAllEmployees(){
		ArrayList<Employee> employees = new ArrayList<Employee>();
		for(int i = 0 ; i<this.departments.size(); i++) {
			employees.addAll(this.departments.get(i).getEmployees());
		}
		return employees;
	}
	
	public String getNom() {
		return name;
	}
	public void setNom(String name) {
		this.name = name;
	}
	public ArrayList<Department> getDepartements() {
		return departments;
	}
	public void setDepartements(ArrayList<Department> departments) {
		this.departments = departments;
	}

	public ArrayList<CheckTime> getChecks() {
		return this.checks;
	}
	
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
