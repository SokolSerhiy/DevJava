package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="_user")
public class User extends AbstractEntity{

	private String password;
	
	private String login;
	@OneToMany(mappedBy="user")
	private List<Order> orders = new ArrayList<>();
	
	public User(String password, String login) {
		this.password = password;
		this.login = login;
	}

	public User() {
	}
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "User [password=" + password + ", login=" + login + "]";
	}
}
