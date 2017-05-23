package less07;

public class Car {

	private final String model;
	
	private final String producer;

	public Car(String model, String producer) {
		this.model = model;
		this.producer = producer;
	}
	
	public boolean equalProducer(Car car){
		return producer.equals(car.producer);
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
