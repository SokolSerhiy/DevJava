package ua.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cafe")
public class Cafe extends AbstractEntity{
	
	private BigDecimal rate;
	
	private String name;
	
	private String photoUrl;
	
	private int version;
	
	private String address;
	
	private String shortDescription;
	
	@Lob
	private String fullDescription;
	
	@Enumerated
	private Type type;
	
	@Column(length=13)
	private String phone;
	
	private String email;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private OpenClose open;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private OpenClose close;
	
	@OneToMany(mappedBy="cafe")
	private List<ua.entity.Table> tables = new ArrayList<>();
	
	@OneToMany(mappedBy="cafe")
	private List<Meal> meals = new ArrayList<>();
	
	public List<Meal> getMeals() {
		return meals;
	}
	public void setMeals(List<Meal> meals) {
		this.meals = meals;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getFullDescription() {
		return fullDescription;
	}
	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public OpenClose getOpen() {
		return open;
	}
	public void setOpen(OpenClose open) {
		this.open = open;
	}
	public OpenClose getClose() {
		return close;
	}
	public void setClose(OpenClose close) {
		this.close = close;
	}
	public List<ua.entity.Table> getTables() {
		return tables;
	}
	public void setTables(List<ua.entity.Table> tables) {
		this.tables = tables;
	}
}
