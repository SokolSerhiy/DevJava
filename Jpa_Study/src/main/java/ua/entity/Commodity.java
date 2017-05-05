package ua.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="commodity")
public class Commodity extends AbstractEntity{

	private String name;
	
	private BigDecimal price;
	@OneToMany(mappedBy="commodity")
	private List<Order> orders = new ArrayList<>();
	
	public Commodity() {
	}

	public Commodity(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Commodity [name=" + name + ", price=" + price + "]";
	}
}
