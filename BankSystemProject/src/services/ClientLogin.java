package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import server.ServerMain;

public class ClientLogin {
	
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement stt = null;
	
	public ClientLogin(String ID, String Password) throws SQLException {
	conn = ServerMain.getConnection();
	String loginSQL = "SELECT * FROM users WHERE id = ? AND senha = ?";
	PreparedStatement pstmt = conn.prepareStatement(loginSQL);
	pstmt.setString(1, ID);
	pstmt.setString(2, Password);
	ResultSet rs = pstmt.executeQuery();

	if (rs.next()) {
	    System.out.println("Existe!");
	} else {
		System.out.println("Não Existe!");
	}
	ServerMain.closeConnection();
	}
	

}
