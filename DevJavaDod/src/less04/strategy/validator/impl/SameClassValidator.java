package less04.strategy.validator.impl;

import less04.strategy.exception.ПомилкаГри;
import less04.strategy.validator.Validator;

public class SameClassValidator implements Validator {

	private final Validator validator;
	
	public SameClassValidator(Validator validator) {
		this.validator = validator;
	}

	@Override
	public void validate(Object[] objects) {
		validator.validate(objects);
		if(objects[0]==null) throw new ПомилкаГри("Жоден екземпляр не може бути null");
		Object object = objects[0];
		for (int i = 1; i < objects.length; i++) {
			if(objects[i]!=null&&object.getClass()!=objects[i].getClass()){
				throw new ПомилкаГри("Усі люди мають бути одного класу Human");
			}
		}
		System.out.println("Перевірка SameClass пройдена");
	}

}
