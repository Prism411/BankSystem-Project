package server;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;


public class ServerMain {
	
	private static Connection conn = null;

	
	public static Connection getConnection() {
		if (conn == null) {
			try {
			Properties props = loadProperties();
			String url = props.getProperty("dburl");
			conn = DriverManager.getConnection(url, props);
			} catch(SQLException e) {
				e.printStackTrace();
				throw new ServerException("teste");
			}
		}
		return conn;
	}
		
		public static void closeConnection() {
			if (conn != null) {
				try {conn.close();}
				catch(SQLException e) {
					throw new ServerException("teste");
				}
			}
		}
	
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("Server.properties")){
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			e.printStackTrace();
			throw new ServerException("Errou!");
		}
	}
	
	public static void CloseSt(Statement st) {
	try {
		st.close();
	} catch (SQLException e) {

		e.printStackTrace();
		throw new ServerException("erroustatment!");
	}
	}
	
	public static void CloseRS(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServerException("errouset!");
		}
	}
	
	
	}
	
	