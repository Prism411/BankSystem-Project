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
import java.util.InputMismatchException;
import java.util.Scanner;
import services.clientActions;
import entities.Client;
import entities.ClientCredentials;
public class Program {

	public static void main(String[] args) throws SQLException, ParseException {
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	boolean sucess = false;
	System.out.println("Bem vindo ao Sistema de Banco BPSJ!");
	System.out.println("Voce deseja criar uma conta, ou se logar com uma nova?");
	System.out.println("  1 - (Criar conta)         2 - (Entrar Com conta)");
	int opcao = 0;
	
	while (sucess == false) {
	try {
	System.out.println("Digite um numero!");
	opcao = sc.nextInt(); 
	if (opcao > 2 || opcao < 1) {
		sucess = false;
		System.out.println( "apenas 1 ou 2 !");
	} else {
	sucess = true;}
	
	} catch (InputMismatchException e) {
		    sc.next(); 
		    sucess = false;
	}}
	sc.nextLine(); 
	
	
	switch (opcao) {
	case 1:
		System.out.print("Entre com o nome do cliente: ");
			String name = sc.nextLine();
		System.out.print("Entre com o email do cliente: ");
			String email = sc.nextLine();
		System.out.print("Entre com a data de nascimento do cliente (dd//MM/yyyy): ");
			Date date = sdf.parse(sc.nextLine());
		System.out.print("Entre com o ID (isso será usado no login: ");
			String id = sc.nextLine();
		System.out.print("Entre com a senha(isso será usado no login: ");
			String senha = sc.nextLine();
	
		ClientLogin cl_1 = new ClientLogin(id,senha,opcao); // opcao is the mode selected to clientLogin
		
		Client client = new Client(id,name,email,date);
		cl_1.ClientCreate(client);
		System.out.println(client);
		break;
		case 2:
			System.out.println("Insira o ID:");
				String id_2 = sc.nextLine();
			System.out.println("Insira o ID:");
				String senha_2 = sc.nextLine();
			ClientLogin cl_2 = new ClientLogin(id_2,senha_2,opcao);
			break;
	}
	
	
	}
} 

	/*int id = 32;
	Date date = sdf.parse("12/05/2018");
	double money =320;
	Client client = new Client(id,"joao","Joao@hotmail",date,money);
	System.out.println(client);
	clientActions ca = new clientActions(client);
	client.setCurrency(ca.addMoney(money));
	client.setCurrency(ca.removeMoney(money +920));
	System.out.println("Depois de adicionar dinheiro");
	System.out.println(client);*/
	
	
	
	

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

	

