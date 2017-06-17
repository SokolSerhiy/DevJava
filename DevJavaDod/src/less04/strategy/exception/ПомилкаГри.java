package less04.strategy.exception;

public class ПомилкаГри extends RuntimeException{

	private static final long serialVersionUID = 640831589181817936L;

	public ПомилкаГри(String message) {
		super(message);
	}
}
