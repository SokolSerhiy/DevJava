package less08.figure;

public interface Figure {

	double perimetr();
	
	double square();
	
	public default void print(){
		System.out.println("Perimetr = "+this.perimetr());
		System.out.println("Square = "+this.square());
	}
}
