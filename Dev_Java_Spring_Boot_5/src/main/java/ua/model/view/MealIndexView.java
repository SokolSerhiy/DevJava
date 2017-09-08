package ua.model.view;

import java.math.BigDecimal;

public class MealIndexView {

	private Integer id;
	
	private String photoUrl;
	
	private int version;
	
	private BigDecimal rate;
	
	private String name;
	
	private String shortDescription;
	
	public MealIndexView(Integer id, String photoUrl, int version, BigDecimal rate, String name, String shortDescription) {
		this.id = id;
		this.photoUrl = photoUrl;
		this.version = version;
		this.rate = rate;
		this.name = name;
		this.shortDescription = shortDescription;
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

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
}
