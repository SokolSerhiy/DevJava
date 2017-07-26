package ua.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cargo")
public class Cargo extends AbstractEntity{

	@ManyToOne(fetch=FetchType.LAZY)
	private Goods goods;
	
	private int weight;
	
	private int height;
	
	private int width;
	
	private int length;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private City cityFrom;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private City cityTo;
	
	private BigDecimal price;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Owner owner;

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public City getCityFrom() {
		return cityFrom;
	}

	public void setCityFrom(City cityFrom) {
		this.cityFrom = cityFrom;
	}

	public City getCityTo() {
		return cityTo;
	}

	public void setCityTo(City cityTo) {
		this.cityTo = cityTo;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
}
