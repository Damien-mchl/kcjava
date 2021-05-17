package kcjava;

import java.util.*;

public class Company {
	private String name;
	private ArrayList<Department> departments;
	
	public Company(String name) {
		this.name = name;
		this.departments = new ArrayList<Department>();
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
	
	
}
