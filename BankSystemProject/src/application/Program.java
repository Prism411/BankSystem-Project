package application;

import server.ServerMain;

public class Program {

	public static void main(String[] args) {
		
		ServerMain.getConnection();
		ServerMain.closeConnection();
		
		
		
		
		
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
