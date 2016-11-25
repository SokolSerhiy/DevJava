package core.less3;

public final class ValueObject {

	public final int size;
	
	public final String color;

	public ValueObject(final int size,final String color) {
		this.size = size;
		this.color = color;
	}
	
	public final ValueObject changeSize(final int size){
		return new ValueObject(size, color);
	}
	
	public final ValueObject changeColor(final String color){
		return new ValueObject(size, color);
	}

	@Override
	public String toString() {
		return "ValueObject [size=" + size + ", color=" + color + "]";
	}
}