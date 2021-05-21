package kcjava;

import java.util.*;

public class Department {
	private String name;
	private ArrayList<Employee> employees;
	/*
	 * @brief Constructeur de la classe Departement

	 * @param String name
	 * 
	 * */
	public Department(String name) {
		this.name = name;
		this.employees = new ArrayList<Employee>();
	}
	/*
	 * @brief Ajoute un employé au tableau des employés

	 * @param Employee e
	 * 
	 * */
	public void addEmployee(Employee e) {
		this.employees.add(e);
	}
	/*
	 * @brief Supprime un employé du tableau des employés

	 * @param Employee e
	 * 
	 * */
	public void removeEmployee(Employee e) {
		this.employees.remove(e);
	}
	/*
	 * @brief Getter de Name

	 * @return String name
	 * 
	 * */
	public String getName() {
		return name;
	}
	/*
	 * @brief Setter de Name

	 * @param String name
	 * 
	 * */
	public void setNom(String name) {
		this.name = name;
	}
	/*
	 * @brief Getter de employees

	 * @return ArrayList<Employee> employees
	 * 
	 * */
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	/*
	 * @brief Setter de employees

	 * @param ArrayList<Employee> employees
	 * 
	 * */
	public void setEmployes(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	
	
	
}
