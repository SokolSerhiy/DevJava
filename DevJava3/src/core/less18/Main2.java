package core.less18;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Main2 {

	public static void main(String[] args) {
		Stage stage = new ArenaLviv();
		List<Artist> artists = new ArrayList<>();
		artists.add(getProxy(new Loboda()));
		artists.add(getProxy(new HardKiss()));
		artists.add(getProxy(new Navy()));
		for (Artist artist : artists) {
			stage.performance(artist);
		}
	}
	
	static Artist getProxy(Artist artist){
		InvocationHandler hendler = getHendler(artist);
		return (Artist) Proxy.newProxyInstance(artist.getClass()
				.getClassLoader(), artist.getClass().getInterfaces()
				, hendler); 
	}
	
	static InvocationHandler getHendler(final Artist artist){
		return new InvocationHandler() {
			private final Object target = artist;
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if(method.isAnnotationPresent(Привіт.class))
				System.out.println(target.getClass().getSimpleName()+": Привіт!!!");
				Object res = method.invoke(target, args);
				return res;
			}
		};
	}
	
	static Artist getProxySimple(Artist artist){
		return new Artist() {
			private Artist target = artist;
			@Override
			public String singing() {
				System.out.println(target.getClass().getSimpleName()+": Привіт!!!");
				return target.singing();
			}
		};
	}
}
