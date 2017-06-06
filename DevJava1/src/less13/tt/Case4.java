package less13.tt;

import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Case4 implements Case{
	
	private final Scanner sc;
	
	private final Map<Profession, List<Person>> map;
	
	public Case4(Scanner sc, Map<Profession, List<Person>> map) {
		this.sc = sc;
		this.map = map;
	}

	@Override
	public boolean work() {
		System.out.println("Enter file name");
		try(FileWriter fw = new FileWriter(sc.next()+".txt")){
			Set<Profession> keys = map.keySet();
			for (Profession key : keys) {
				for(Person person : map.get(key)){
					String str = key.getName()+" "+key.getMinPayment()+" "
							+person.getName()+" "+person.getPayment()+"\n";
					fw.write(str);
				}
				if(map.get(key).isEmpty()){
					String str = key.getName()+" "+key.getMinPayment()+"\n";
					fw.write(str);
				}
			}
		}catch (Exception e) {
		}
		return true;
	}

}
