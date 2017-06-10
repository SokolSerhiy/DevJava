package less09;

public interface Figure {

	double square();
	
	double perimetr();
	
	public default void print(){
		System.out.println("Perimetr = "+this.perimetr()+" square = "+this.square());
	}
}