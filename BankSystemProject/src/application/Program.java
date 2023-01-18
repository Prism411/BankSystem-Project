package application;

import server.ServerMain;

public class Program {

	public static void main(String[] args) {
		
		ServerMain.getConnection();
		ServerMain.closeConnection();
		


	}

}
