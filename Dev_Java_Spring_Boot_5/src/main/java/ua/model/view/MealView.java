package ua.model.view;

import java.math.BigDecimal;
import java.util.List;

public class MealView {

	private Integer id;
	
	private String photoUrl;
	
	private int version;
	
	private BigDecimal rate;
	
	private String name;
	
	private String fullDescription;
	
	private BigDecimal price;
	
	private List<ComponentView> components;
	
	private int weight;
	
	private String cuisine;
	
	public MealView(Integer id, String photoUrl, int version, BigDecimal rate, String name, String fullDescription, BigDecimal price, int weight, String cuisine) {
		this.id = id;
		this.photoUrl = photoUrl;
		this.version = version;
		this.rate = rate;
		this.name = name;
		this.fullDescription = fullDescription;
		this.price = price;
		this.weight = weight;
		this.cuisine = cuisine;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<ComponentView> getComponents() {
		return components;
	}

	public void setComponents(List<ComponentView> components) {
		this.components = components;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	@Override
	public String toString() {
		return "MealView [id=" + id + ", photoUrl=" + photoUrl + ", version=" + version + ", rate=" + rate + ", name="
				+ name + ", fullDescription=" + fullDescription + ", price=" + price + ", components=" + components
				+ ", weight=" + weight + ", cuisine=" + cuisine + "]";
	}
}