package ua.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="transporter")
public class Transporter extends AbstractEntityName{

	private BigDecimal rate;
	
	private int maxWeight;
	
	private String photoUrl;
	
	private int version;
	
	@Column(name="_count")
	private int count;
	
	private int age;
	@Column(length=13)
	private String phone;
	@ManyToOne(fetch=FetchType.LAZY)
	private Brand brand;
	@ManyToOne(fetch=FetchType.LAZY)
	private Model model;
	
	private int carAge;
	@ManyToOne(fetch=FetchType.LAZY)
	private City cityArrive;
	
	private LocalDateTime dateArrive;
	@Enumerated
	private Status status;
	
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public int getMaxWeight() {
		return maxWeight;
	}
	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public int getCarAge() {
		return carAge;
	}
	public void setCarAge(int carAge) {
		this.carAge = carAge;
	}
	public City getCityArrive() {
		return cityArrive;
	}
	public void setCityArrive(City cityArrive) {
		this.cityArrive = cityArrive;
	}
	public LocalDateTime getDateArrive() {
		return dateArrive;
	}
	public void setDateArrive(LocalDateTime dateArrive) {
		this.dateArrive = dateArrive;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
