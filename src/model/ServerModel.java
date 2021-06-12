package model;

import kcjava.Company;

public class ServerModel {
	private Company company;
	/**
	 * constructeur
	 * @param company entreprise
	 */
	public ServerModel(Company company) {
		this.company = company;
	}
	/**
	 * @return entreprise
	 */
	public Company getCompany() {
		return company;
	}
	
}
