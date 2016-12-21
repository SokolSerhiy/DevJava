package library.model;

public class Book implements Tenancy{

	private static final long serialVersionUID = -4578584838671427294L;

	private transient String id;
	
	private String title;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String getId() {
		return id;
	}
}