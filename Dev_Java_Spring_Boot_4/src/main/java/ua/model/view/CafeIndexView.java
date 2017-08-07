package ua.model.view;

import java.math.BigDecimal;

public class CafeIndexView {

	private Integer id;
	
	private BigDecimal rate;
	
	private String name;
	
	private String photoUrl;
	
	private int version;
	
	private String address;
	
	private String shortDescription;
	
	private String type;

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

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
