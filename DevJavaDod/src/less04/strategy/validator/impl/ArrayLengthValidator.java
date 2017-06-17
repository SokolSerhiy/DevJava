package less04.strategy.validator.impl;

import less04.strategy.exception.ПомилкаГри;
import less04.strategy.validator.Validator;

public class ArrayLengthValidator implements Validator{

	@Override
	public void validate(Object[] objects) {
		if(objects.length==0) throw new ПомилкаГри("Потрібно передати хоча б один екземпляр Human");
		System.out.println("Перевірка ArrayLength пройдена");
	}
}
