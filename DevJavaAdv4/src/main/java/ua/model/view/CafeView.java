package ua.model.view;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import ua.entity.Type;

public class CafeView {

	private Integer id;
	
	private BigDecimal rate;
	
	private String name;
	
	private String photoUrl;
	
	private int version;
	
	private String address;
	
	private String fullDescription;
	
	private String type;
	
	private String phone;
	
	private String email;
	
	private String open;
	
	private String close;
	
	public CafeView(Integer id, BigDecimal rate, String name, String photoUrl, int version, String address,String fullDescription, Type type, String phone, String email, LocalTime open, LocalTime close) {
		this.id = id;
		this.rate = rate;
		this.name = name;
		this.photoUrl = photoUrl;
		this.version = version;
		this.address = address;
		this.fullDescription = fullDescription;
		this.type = type.name();
		this.phone = phone;
		this.email = email;
		this.open = open.format(DateTimeFormatter.ofPattern("HH:mm"));
		this.close = close.format(DateTimeFormatter.ofPattern("HH:mm"));
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

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
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

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	@Override
	public String toString() {
		return "CafeView [id=" + id + ", rate=" + rate + ", name=" + name + ", photoUrl=" + photoUrl + ", version="
				+ version + ", address=" + address + ", fullDescription=" + fullDescription + ", type=" + type
				+ ", phone=" + phone + ", email=" + email + ", open=" + open + ", close=" + close + "]";
	}
}