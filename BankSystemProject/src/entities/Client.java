package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private int id;
	private String name;
	private String Email;
	private Date birthdate;
	private double currency;
	
	public Client() {
	}
	
	public Client(int id, String name, String email, Date birthdate, double currency) {
		this.id = id;
		this.name = name;
		Email = email;
		this.birthdate = birthdate;
		this.currency = currency;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public double getCurrency() {
		return currency;
	}
	public void setCurrency(double currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", Email=" + Email + ", birthdate=" + sdf.format(birthdate) + ", currency="
				+ currency + "]";
	}
	
	
}
