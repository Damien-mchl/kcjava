package kcjava;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;



public class Company {
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
		return checks;
	}
	

}
