package less07;

public class Car {

	private final String model;
	
	public final String producer;

	public Car(final String model, final String producer) {
		this.model = model;
		this.producer = producer;
	}
	
	

	@Override
	public String toString() {
		return "Car [model=" + model + ", producer=" + producer + "]";
	}
	
	
//	public void setModel(String model){
//		if(model!=null&&!model.isEmpty())
//		this.model = model;
//	}
//	
//	public String getModel(){
//		return model;
//	}
	
	
}
