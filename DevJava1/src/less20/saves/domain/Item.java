package less20.saves.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Item {
	
	String getId();

	String getName();
	
	BigDecimal getPrice();
	
	LocalDate getDate();
	
	void save();
	
}