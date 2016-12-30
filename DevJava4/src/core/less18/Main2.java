package core.less18;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Main2 {

	public static void main(String[] args) {
		List<Artist> artists = new ArrayList<>();
		artists.add(getProxy(new Eminem()));
		artists.add(getProxySimple(new Basta()));
		artists.add(getProxy(new Metalica()));
		Stage stage = new ArenaLviv();
		for (Artist artist : artists) {
			stage.performance(artist);
		}
	}
	
	static Artist getProxy(Artist artist){
		InvocationHandler hendler = (proxy, method, args)->{
			System.out.println(artist.getClass().getSimpleName()+": Hello");
			Object res = method.invoke(artist, args);
			System.out.println(artist.getClass().getSimpleName()+": By-by");
			return res;
		};
		return (Artist) Proxy.newProxyInstance(artist.getClass()
				.getClassLoader(), artist.getClass().getInterfaces(), 
				hendler);
	}
	
	static Artist getProxySimple(Artist artist){
		return new Artist() {
			@Override
			public void singing() {
				System.out.println(artist.getClass().getSimpleName()+": Hello");
				artist.singing();
				System.out.println(artist.getClass().getSimpleName()+": By-by");
			}
		};
	}
}