package kcjava;

import java.io.Serializable;
import java.util.*;

public class Department implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	 * @brief Ajoute un employ� au tableau des employ�s

	 * @param Employee e
	 * 
	 * */
	public void addEmployee(Employee e) {
		if(!this.employees.contains(e))
			this.employees.add(e);
	}
	/*
	 * @brief Supprime un employ� du tableau des employ�s

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
	/*
	 * @brief recherche un employ� dans le d�partement
	 * 
	 * @param int l'id de l'employ�
	 * 
	 * @return boolean vrai si l'employ� est pr�sent, faux sinon
	 * */
	public boolean containsEmployeeDep(int id) {
		boolean contains = false;
		for(int i=0; i<this.employees.size(); i++) {
			if(this.employees.get(i).getId()==id) {
				contains = true;
			}
		}
		return contains;
	}
	/*
	 * @brief modifie le planning d'un employ� du d�partement
	 * 
	 * @param int l'id de l'employ�
	 * @param Planning le planning souhait�
	 * 
	 * */
	public void modifyEmployeeDep(int id, Planning planning) {
		for(int i=0; i<this.employees.size(); i++) {
			if(this.employees.get(i).getId()==id) {
				this.employees.get(i).setPlanning(planning);
			}
		}
	}
	
	
	
}
