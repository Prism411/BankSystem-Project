package services;

import entities.Client;

public class clientActions {
	
	protected Client client;
	
	public clientActions(Client client) {
		this.client = client;
	}
	public double addMoney(double money) {
		
		double moneyStored = client.getCurrency();
		return moneyStored += money;
		
	}
	
	public double removeMoney(double money) {
		
		double moneyStored = client.getCurrency();
		return moneyStored -= money;
		
	}

}
