package lesson4.controller;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.*;

import lesson4.model.Car;
import lesson4.model.Helm;

public class Controller {

	private final List<Car> cars = new ArrayList<>();
	private final Helm defHelm = new Helm(true, 100);
	private final Car defCar = new Car("Deafault", false, 13, 14);

	public Controller() {
		cars.add(new Car("Red", true, 15, 18));
		cars.add(new Car("Green", false, 14, 20));
		cars.add(new Car("Gray", true, 15, 18));
		cars.add(new Car("Black", false, 16, 18));
		cars.add(new Car("Red", false, 17, 20));
		cars.add(new Car("Blue", true, 14, 17));
		cars.add(new Car("Yellow", false, 14, 19));
		cars.add(new Car("Brown", true, 15, 18));
		cars.add(new Car("Red", true, 13, 15));
	}

	public List<Car> findByDiametr(int diametr){
//		List<Car> list = new ArrayList<>();
//		for (Car car : cars) {
//			if(car.getWheel().getDiametr()==diametr){
//				list.add(car);
//			}
//		}
//		return list;
		return cars.stream()
		.filter(car -> car.getWheel().getDiametr()==diametr)
		.collect(toList());
	}
	
	public List<Car> findByDiametrAndColor(int diametr, String color){
//		List<Car> list = new ArrayList<>();
//		for (Car car : cars) {
//			if(car.getWheel().getDiametr()==diametr&&car.getBody().getColor().equals(color)){
//				list.add(car);
//			}
//		}
//		return list;
		return cars.stream()
		.filter(car -> car.getWheel().getDiametr()==diametr)
		.filter(car -> car.getBody().getColor().equals(color))
		.collect(toList());
	}
	
	public List<Car> changeHelm(){
		cars.stream()
		.filter(car -> car.getBody().getColor().equals("Red"))
		.forEach(car -> car.setHelm(defHelm));
//		for (Car car : cars) {
//			if(car.getBody().getColor().equals("Red")){
//				car.setHelm(defHelm);
//			}
//		}
		return cars;
	}
	
	public List<Car> increase(){
		cars.stream().filter(car->car.getHelm().isHaveButtons())
		.forEach(car->car.getWheel().setDiametr(car.getWheel().getDiametr()*2));
//		for (Car car : cars) {
//			if(car.getHelm().isHaveButtons()){
//				car.getWheel().setDiametr(car.getWheel().getDiametr()*2);
//			}
//		}
		return cars;
	}
	
	public List<Car> changeCar(int diametr){
		cars.replaceAll(car->{
			if(car.getWheel().getDiametr()<diametr){
				return defCar;
			}
			return car;
		});
//		for (Car car : cars) {
//			if(car.getWheel().getDiametr()<diametr){
//				cars.set(cars.indexOf(car), defCar);
//			}
//		}
		return cars;
	}
	
}
