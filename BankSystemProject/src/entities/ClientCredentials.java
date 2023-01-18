package entities;

import java.util.Objects;

public class ClientCredentials {
	
	private String id;
	private String password;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ClientCredentials(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientCredentials other = (ClientCredentials) obj;
		return Objects.equals(id, other.id) && Objects.equals(password, other.password);
	}

	public String toString() {
		return "ClientCredentials [id=" + id + ", password=" + password + "]";
	}
	
	
	
}
	
	