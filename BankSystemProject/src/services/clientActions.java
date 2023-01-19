package services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JTextArea;

import entities.Client;
import server.ServerMain;

public class clientActions {
	
	protected Client client;
	
	Connection conn = ServerMain.getConnection();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement stt = null;
	
	
	public clientActions(Client client) {
		this.client = client;
	}
	

	public void ClientMenu(Client client) {	
		this.client = client;
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
			try {while (opcao != 3) {
			clearConsole();
			double money = refreshMoney();
			System.out.println("----------Sistema de Banco BPSJ--------------");
			System.out.printf("Current User: %s || Name : %s || Currency : %.2f%n", client.getId(), client.getName(), money);
			System.out.println("1 - Realizar Deposito");
			System.out.println("2 - Realizar Saque");
			System.out.println("3 - Sair");
			opcao = sc.nextInt();
			
			switch (opcao) {
			
			case 1: System.out.println("Insert Quantity");
			double aQ = sc.nextDouble();
			addMoney(aQ); break;
			
			case 2:System.out.println("Insert Quantity");
			double rQ = sc.nextDouble();
			removeMoney(rQ); break;
			
			}
			
		} } catch (SQLException e) {
				e.printStackTrace();}
	}
	
	
	
	
	
			
			
		
	public void addMoney(double money) throws SQLException {
		double salary = refreshMoney();
		try {
			    salary += money;
		    String updateSQL = "UPDATE client SET salary = ? WHERE id = ?";
		    PreparedStatement ps = conn.prepareStatement(updateSQL);
		    ps.setDouble(1, salary);
		    ps.setString(2, client.getId());
		ps.executeUpdate();
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void removeMoney(double money) {
		try {
		double salary = refreshMoney();

			    salary -= money;
		    String updateSQL = "UPDATE client SET salary = ? WHERE id = ?";
		    PreparedStatement ps = conn.prepareStatement(updateSQL);
		    ps.setDouble(1, salary);
		    ps.setString(2, client.getId());
		ps.executeUpdate();
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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
	
	public double refreshMoney() throws SQLException {
		double salary = 0;
	    String clientSQL = "SELECT * FROM client WHERE id = ?";
	    PreparedStatement pstmt2 = conn.prepareStatement(clientSQL);
	    pstmt2.setString(1, client.getId());
	    ResultSet rs2 = pstmt2.executeQuery();
	    if (rs2.next()) {
	        salary = rs2.getDouble("salary");
		
	}
		return salary;
	

}
}
