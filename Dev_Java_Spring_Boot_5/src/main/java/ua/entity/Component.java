package ua.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="component")
public class Component extends AbstractEntity{

	@ManyToOne(fetch=FetchType.LAZY)
	private Ingredient ingredient;
	
	private BigDecimal amount;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Ms ms;
	
	@ManyToMany(mappedBy="components")
	private List<Meal> meals = new ArrayList<>();

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Ms getMs() {
		return ms;
	}

	public void setMs(Ms ms) {
		this.ms = ms;
	}
}
