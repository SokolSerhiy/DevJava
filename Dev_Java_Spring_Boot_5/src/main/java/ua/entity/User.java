package ua.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="_user")
public class User extends AbstractEntity{

	private String email;
	
	private String password;
	
	private Role role;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
