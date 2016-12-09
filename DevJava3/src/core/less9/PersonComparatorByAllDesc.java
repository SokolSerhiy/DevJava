package core.less9;

import java.util.Comparator;

import core.less6.Person;

public class PersonComparatorByAllDesc implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		int res = o2.getName().compareTo(o1.getName());
		if(res!=0)return res;
		res = o2.getAge() - o1.getAge();
		if(res!=0)return res;
		return o2.getGender().compareTo(o1.getGender());
	}

}
