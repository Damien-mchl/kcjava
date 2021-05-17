package kcjava;

import java.util.*;

public class Department {
	private String name;
	private ArrayList<Employee> employees;
	
	public Department(String name) {
		this.name = name;
		this.employees = new ArrayList<Employee>();
	}
	
	public void addEmployee(Employee e) {
		this.employees.add(e);
	}
	
	public void removeEmployee(Employee e) {
		this.employees.remove(e);
	}
	
	public String getNom() {
		return name;
	}

	public void setNom(String name) {
		this.name = name;
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployes(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	
	
	
}
