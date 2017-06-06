package less13.tt;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Case3 implements Case{

	private final Map<Profession, List<Person>> map;

	public Case3(Map<Profession, List<Person>> map) {
		this.map = map;
	}

	@Override
	public boolean work() {
		Set<Profession> keys = map.keySet();
		for (Profession key : keys) {
			for(Person person : map.get(key)){
				System.out.println(key+" "+person);
			}
			if(map.get(key).isEmpty())System.out.println(key);
		}
		return true;
	}
	
	
}
