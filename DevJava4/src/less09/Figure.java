package less09;

public interface Figure {

	double perimetr();
	
	double square();
	
	public default void print(){
		System.out.println("Square = "+this.square()+" perimetr = "+this.perimetr());
	}
}
