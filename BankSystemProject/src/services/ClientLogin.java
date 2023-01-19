package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import entities.Client;
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

        String clientSQL = "SELECT * FROM client WHERE id = ?";
        PreparedStatement pstmt2 = conn.prepareStatement(clientSQL);
        pstmt2.setString(1, ID);
        ResultSet rs2 = pstmt2.executeQuery();
        if (rs2.next()) {
            String id = rs2.getString("id");
            String email= rs2.getString("email");
            String name = rs2.getString("name");
            Date birthdate = rs2.getDate("birthdate");
            double salary = rs2.getDouble("salary");

            Client client = new Client(id, name, email, birthdate, salary);
            clientActions.ClientMenu(client);
	}
	}
		
	    
	 else {
		
		switch (Mode) {
		
		case 1:
		System.out.println("Não Existe!");
		String registerSQL = "INSERT INTO users (id, senha) VALUES (?, ?)";
		PreparedStatement ps = conn.prepareStatement(registerSQL);
		ps.setString(1, ID);
		ps.setString(2, Password);
		ps.executeUpdate();
		System.out.println("Login criado.. provavelmente"); break;
		
		case 2:
			System.out.println("Não existe!sdsdsds");
			break;
	}
	
	 }
		


	}
	
	public void ClientCreate(Client client) {
		    conn = ServerMain.getConnection();
		    String id = client.getId();
		    String name = client.getName();
		    String email = client.getEmail();
		    Date date = client.getBirthdate();
		    double currency = client.getCurrency();
		    try {
		        String registerSQL = "INSERT INTO client (id, email, name, birthdate, salary) VALUES (?, ?, ?, ?, ?)";
		        PreparedStatement ps = conn.prepareStatement(registerSQL);
		        ps.setString(1, id);
		        ps.setString(2, email);
		        ps.setString(3, name);
		        ps.setDate(4, new java.sql.Date(date.getTime()));
		        ps.setDouble(5, currency);
		        ps.executeUpdate();
		        System.out.println("Login created.. probably");
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    ServerMain.closeConnection();
		}


}

