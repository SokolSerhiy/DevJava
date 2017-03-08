package ua.dto.filter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AmountFilter {

	private String max = "";
	
	private String min = "";
	
	private BigDecimal maxValue;
	
	private BigDecimal minValue;
	
	private List<Long> ingredientId = new ArrayList<>();

	private List<Long> systemId = new ArrayList<>();

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public BigDecimal getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(BigDecimal maxValue) {
		this.maxValue = maxValue;
	}

	public BigDecimal getMinValue() {
		return minValue;
	}

	public void setMinValue(BigDecimal minValue) {
		this.minValue = minValue;
	}

	public List<Long> getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(List<Long> ingredientId) {
		this.ingredientId = ingredientId;
	}

	public List<Long> getSystemId() {
		return systemId;
	}

	public void setSystemId(List<Long> systemId) {
		this.systemId = systemId;
	}
}