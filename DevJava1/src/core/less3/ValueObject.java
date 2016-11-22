package core.less3;

public final class ValueObject {

	public final String color;
	
	public final int size;

	public ValueObject(final String color,final int size) {
		this.color = color;
		this.size = size;
	}
	
	public final ValueObject changeColor(final String color){
		return new ValueObject(color, size);
	}
	
	public final ValueObject changeSize(final int size){
		return new ValueObject(color, size);
	}
}
