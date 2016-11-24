package core.less4;

public interface Geometric {

	double square();
	
	double perimetr();
	
	public default void print(){
		System.out.println("Square = "+square());
		System.out.println("Perimetr = "+perimetr());
	}
}
