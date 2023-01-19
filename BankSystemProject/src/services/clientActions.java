package services;

import entities.Client;

public class clientActions {
	
	protected Client client;
	
	public clientActions(Client client) {
		this.client = client;
	}
	
	
	public static void ClientMenu(Client client) {
		System.out.println("----------Sistema de Banco BPSJ--------------");
		System.out.printf("Current User: %s || Name : %s || Currency : %f", client.getId(), client.getName(), client.getCurrency());
		
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
