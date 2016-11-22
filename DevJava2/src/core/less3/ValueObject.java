package core.less3;

public final class ValueObject {

	public final String color;
	
	public final int size;

	public ValueObject(final String color,final int size) {
		this.color = color;
		this.size = size;
	}
	
	public ValueObject changeColor(String color){
		return new ValueObject(color, size);
	}
	
	public ValueObject changeSize(int size){
		return new ValueObject(color, size);
	}

	@Override
	public String toString() {
		return "ValueObject [color=" + color + ", size=" + size + "]";
	}
}
