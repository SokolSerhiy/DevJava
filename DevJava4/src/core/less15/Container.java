package core.less15;

import java.io.Serializable;
import java.util.List;

public class Container<T extends Serializable> implements Serializable {

	private static final long serialVersionUID = 5683188063125091370L;

	private T element;
	
	private List<T> list;

	public Container(T element) {
		this.element = element;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}
}