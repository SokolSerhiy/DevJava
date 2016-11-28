package core.less4;

public interface Geometric {

	double square();
	
	double perimetr();
	
	public default void print(){
		System.out.println("Square = "+this.square());
		System.out.println("Perimetr = "+this.perimetr());
	}
}
