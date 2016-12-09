package core.less9;

import java.util.Comparator;

import core.less6.Person;

public class PersonComparatorByNemaDesc implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		return o2.getName().compareTo(o1.getName());
	}
}