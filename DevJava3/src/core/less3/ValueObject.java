package core.less3;

public final class ValueObject {

	public final int size;
	
	public final String color;

	public ValueObject(final int size,final String color) {
		this.size = size;
		this.color = color;
	}
	
	public ValueObject changeSize(int size){
		return new ValueObject(size, color);
	}
	
	public ValueObject changeColor(String color){
		return new ValueObject(size, color);
	}

	@Override
	public String toString() {
		return "ValueObject [size=" + size + ", color=" + color + "]";
	}
}