package ua.model.view;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import ua.entity.Status;

public class TransporterView {

	private Integer id;
	
	private BigDecimal rate;
	
	private int maxWeight;
	
	private String photoUrl;
	
	private int version;
	
	private String name;
	
	private int count;
	
	private int age;
	
	private String phone;
	
	private String brand;
	
	private String model;
	
	private int carAge;
	
	private String cityArrive;
	
	private String dateArrive;
	
	private String status;
	
	public TransporterView(Integer id, BigDecimal rate, int maxWeight, String photoUrl, int version, String name,int count, int age, String phone, String brand, String model, int carAge, String cityArrive,LocalDateTime dateArrive, Status status) {
		this.id = id;
		this.rate = rate;
		this.maxWeight = maxWeight;
		this.photoUrl = photoUrl;
		this.version = version;
		this.name = name;
		this.count = count;
		this.age = age;
		this.phone = phone;
		this.brand = brand;
		this.model = model;
		this.carAge = carAge;
		this.cityArrive = cityArrive;
		this.dateArrive = dateArrive.format(DateTimeFormatter.ofPattern("dd:MM:yy:HH:mm"));
		this.status = status.name();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCarAge() {
		return carAge;
	}

	public void setCarAge(int carAge) {
		this.carAge = carAge;
	}

	public String getCityArrive() {
		return cityArrive;
	}

	public void setCityArrive(String cityArrive) {
		this.cityArrive = cityArrive;
	}

	public String getDateArrive() {
		return dateArrive;
	}

	public void setDateArrive(String dateArrive) {
		this.dateArrive = dateArrive;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TransporterView [id=" + id + ", rate=" + rate + ", maxWeight=" + maxWeight + ", photoUrl=" + photoUrl
				+ ", version=" + version + ", name=" + name + ", count=" + count + ", age=" + age + ", phone=" + phone
				+ ", brand=" + brand + ", model=" + model + ", carAge=" + carAge + ", cityArrive=" + cityArrive
				+ ", dateArrive=" + dateArrive + ", status=" + status + "]";
	}
}
