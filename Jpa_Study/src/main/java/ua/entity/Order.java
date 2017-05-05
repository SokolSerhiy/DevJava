package ua.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="_orders")
public class Order extends AbstractEntity{
	
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	@ManyToOne(fetch=FetchType.LAZY)
	private Commodity commodity;
	
	public Order(User user, Commodity commodity) {
		this.user = user;
		this.commodity = commodity;
	}
	
	public Order() {
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	@Override
	public String toString() {
		return "Order [user=" + user + ", commodity=" + commodity + "]";
	}
}
