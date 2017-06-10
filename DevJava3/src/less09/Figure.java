package less09;

public interface Figure {

	double perimetr();
	
	double square();
	
	public default void print(){
		System.out.println("Perimetr = "+this.perimetr()+" square = "+this.square());
	}
}
