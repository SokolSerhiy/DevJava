package less07;

public class ValueObject {

	public final int size;
	
	public final String color;

	public ValueObject(int size, String color) {
		this.size = size;
		this.color = color;
	}
	
	public ValueObject reSize(int size){
		return new ValueObject(size, color);
	}
	
	public ValueObject reColor(String color){
		return new ValueObject(size, color);
	}
	
	@Override
	public void finalize() throws Throwable {
		System.out.print("I die ");
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "ValueObject [size=" + size + ", color=" + color + "]";
	}
}
