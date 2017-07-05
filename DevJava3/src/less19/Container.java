package less19;

public class Container<E> {

	private E element;
	
	public Container(E element) {
		this.element = element;
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	@Override
	public String toString() {
		return "Container [element=" + element + "]";
	}
}
