package ua.model.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MealFilter {

	private static final Pattern INT_PATTERN = Pattern.compile("[0-9]{1,10}^$");
	
	private static final Pattern DECIMAL_PATTERN = Pattern.compile("^([0-9]{1,18}\\.[0-9]{0,2})|([0-9]{1,18}\\,[0-9]{0,2})|([0-9]{1,18})$");
	
	private String search = "";

	private String minRate = "";
	
	private String maxRate = "";
	
	private String minPrice = "";
	
	private String maxPrice = "";
	
	private String minWeight = "";
	
	private String maxWeight = "";
	
	private List<String> cuisinesIds = new ArrayList<>();
	
	private List<Integer> ingredientIds = new ArrayList<>();

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getMinRate() {
		return minRate;
	}

	public void setMinRate(String minRate) {
		if(DECIMAL_PATTERN.matcher(minRate).matches())
		this.minRate = minRate;
	}

	public String getMaxRate() {
		return maxRate;
	}

	public void setMaxRate(String maxRate) {
		if(DECIMAL_PATTERN.matcher(maxRate).matches())
		this.maxRate = maxRate;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		if(DECIMAL_PATTERN.matcher(minPrice).matches())
		this.minPrice = minPrice;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		if(DECIMAL_PATTERN.matcher(maxPrice).matches())
		this.maxPrice = maxPrice;
	}

	public String getMinWeight() {
		return minWeight;
	}

	public void setMinWeight(String minWeight) {
		if(INT_PATTERN.matcher(minWeight).matches())
		this.minWeight = minWeight;
	}

	public String getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(String maxWeight) {
		if(INT_PATTERN.matcher(maxWeight).matches())
		this.maxWeight = maxWeight;
	}

	public List<String> getCuisinesIds() {
		return cuisinesIds;
	}

	public void setCuisinesIds(List<String> cuisinesIds) {
		this.cuisinesIds = cuisinesIds;
	}

	public List<Integer> getIngredientIds() {
		return ingredientIds;
	}

	public void setIngredientIds(List<Integer> ingredientIds) {
		this.ingredientIds = ingredientIds;
	}
}
