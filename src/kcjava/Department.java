package kcjava;

import java.io.Serializable;
import java.util.*;

public class Department implements Serializable{
	/***
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private ArrayList<Employee> employees;
	/**
	 * Constructeur de la classe Departement

	 * @param name nom du departement
	 * 
	 * */
	public Department(String name) {
		this.name = name;
		this.employees = new ArrayList<Employee>();
	}
	/**
	 * Ajoute un employé au tableau des employés

	 * @param e employé
	 * 
	 * */
	public void addEmployee(Employee e) {
		if(!this.employees.contains(e))
			this.employees.add(e);
	}
	/**
	 * Supprime un employé du tableau des employés

	 * @param e employé
	 * 
	 * */
	public void removeEmployee(Employee e) {
		this.employees.remove(e);
	}
	/**
	 * Getter de Name

	 * @return nom de l'employé
	 * 
	 * */
	public String getName() {
		return name;
	}
	/**
	 * Setter de Name

	 * @param name nom de l'employé
	 * 
	 * */
	public void setNom(String name) {
		this.name = name;
	}
	/**
	 * Getter de employees

	 * @return liste des employees
	 * 
	 * */
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	/**
	 * Setter de employees

	 * @param employees liste des employees
	 * 
	 * */
	public void setEmployes(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	/**
	 * recherche un employé dans le département
	 * 
	 * @param id l'id de l'employé
	 * 
	 * @return boolean vrai si l'employé est présent, faux sinon
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
	/**
	 * modifie le planning d'un employé du département
	 * 
	 * @param id l'id de l'employé
	 * @param planning le planning souhaité
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
