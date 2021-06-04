package model;

import kcjava.Company;

public class ServerModel {
	private Company company;
	public ServerModel(Company company) {
		this.company = company;
	}
	public Company getCompany() {
		return company;
	}
	
}
