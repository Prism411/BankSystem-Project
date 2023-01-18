package application;

import server.ServerMain;
import services.ClientLogin;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import services.clientActions;
import entities.Client;
import entities.ClientCredentials;
public class Program {

	public static void main(String[] args) throws SQLException, ParseException {
		Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	int id = 32;
	Date date = sdf.parse("12/05/2018");
	double money =320;
	Client client = new Client(id,"joao","Joao@hotmail",date,money);
	System.out.println(client);
	clientActions ca = new clientActions(client);
	client.setCurrency(ca.addMoney(money));
	client.setCurrency(ca.removeMoney(money +920));
	System.out.println("Depois de adicionar dinheiro");
	System.out.println(client);
	
	
	
	

		/*System.out.println("Insira Login (ID)");
		String id = sc.nextLine();
		System.out.println("Insira Login (PASSWORD)");
		String password = sc.nextLine();
		ClientLogin cl = new ClientLogin(id,password);/*
		
		
		
/*
 * String createTableSQL = "CREATE TABLE users (username VARCHAR(255), password VARCHAR(255))";
	Statement stmt = conn.createStatement();
	stmt.executeUpdate(createTableSQL);
	
	
	String createTableSQL = "CREATE TABLE users (username VARCHAR(255), password VARCHAR(255))";
	Statement stmt = conn.createStatement();
	stmt.executeUpdate(createTableSQL);
		

*	String loginSQL = "SELECT * FROM users WHERE username = ? AND password = ?";
	pstmt = conn.prepareStatement(loginSQL);
	pstmt.setString(1, "user1");
	pstmt.setString(2, "password1");
	ResultSet rs = pstmt.executeQuery();

	if (rs.next()) {
	    // login successful
	} else {
	    // login failed                          
*/

	}

}
