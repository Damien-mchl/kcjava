package kcjava;

import java.util.*;

public class Company {
	private String name;
	private ArrayList<Department> departments;
	
	/*
	 * @brief Constructeur de la classe Company

	 * @param String name
	 * 
	 * */
	public Company(String name) {
		this.name = name;
		this.departments = new ArrayList<Department>();
	}
	/*
	 * @brief Getter de name

	 * @return String name
	 * 
	 * */
	public String getName() {
		return name;
	}
	
	/*
	 * @brief Setter de name

	 * @param String name
	 * 
	 * */
	public void setName(String name) {
		this.name = name;
	}
	/*
	 * @brief Getter de Departements

	 * @return ArrayList<Department> departments
	 * 
	 * */
	public ArrayList<Department> getDepartements() {
		return departments;
	}
	/*
	 * @brief Setter de Departement
	 * 
	 * @param ArrayList<Department> departments
	 * 
	 * */
	public void setDepartements(ArrayList<Department> departments) {
		this.departments = departments;
	}
	
	
}
