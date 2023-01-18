package application;

import server.ServerMain;
import services.ClientLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import entities.Client;
import entities.ClientCredentials;
public class Program {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Insira Login (ID)");
		String id = sc.nextLine();
		System.out.println("Insira Login (PASSWORD)");
		String password = sc.nextLine();
		ClientLogin cl = new ClientLogin(id,password);
		
		
		
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
