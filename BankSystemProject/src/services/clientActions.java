package services;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.JTextArea;

import entities.Client;

public class clientActions {
	
	protected Client client;
	
	public clientActions(Client client) {
		this.client = client;
	}
	

	public void ClientMenu(Client client) {	
		this.client = client;
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		while (opcao != 3) {
			System.out.println("----------Sistema de Banco BPSJ--------------");
			System.out.printf("Current User: %s || Name : %s || Currency : %.2f%n", client.getId(), client.getName(), client.getCurrency());
			System.out.println("1 - Realizar Deposito");
			System.out.println("2 - Realizar Saque");
			System.out.println("3 - Sair");
			opcao = sc.nextInt();
			
			switch (opcao) {
			case 1: addMoney(320);break;
			case 2: removeMoney(320);break;
			}
			
			
		}

		
	}
	public double addMoney(double money) {
		
		double moneyStored = client.getCurrency();
		return moneyStored += money;
		
	}
	
	public double removeMoney(double money) {
		
		double moneyStored = client.getCurrency();
		return moneyStored -= money;
		
	}
	
	public static void clearConsole() {
	    try {
	        final String os = System.getProperty("os.name");
	        if (os.contains("Windows")) {
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        } else {
	            System.out.print("\033[H\033[2J");
	            System.out.flush();
	        }
	    } catch (final Exception e) {
	        // Handle any exceptions.
	    }
	}
	

}
