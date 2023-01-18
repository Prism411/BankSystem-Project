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
	
	public ClientLogin(String ID, String Password, int Mode) throws SQLException {
	conn = ServerMain.getConnection();
	String loginSQL = "SELECT * FROM users WHERE id = ? AND senha = ?";
	PreparedStatement pstmt = conn.prepareStatement(loginSQL);
	pstmt.setString(1, ID);
	pstmt.setString(2, Password);
	ResultSet rs = pstmt.executeQuery();

	if (rs.next()) {
	    System.out.println("Existe!");
	} else {
		
		if (Mode == 1) {
		System.out.println("Não Existe!");}
		String registerSQL = "INSERT INTO users (id, senha) VALUES (?, ?)";
		PreparedStatement ps = conn.prepareStatement(registerSQL);
		ps.setString(1, ID);
		ps.setString(2, Password);
		ps.executeUpdate();
		System.out.println("Login criado.. provavelmente");}
		
		if (Mode == 2) {
			System.out.println("Não existe!");
		}
	ServerMain.closeConnection();
	}
	

}
