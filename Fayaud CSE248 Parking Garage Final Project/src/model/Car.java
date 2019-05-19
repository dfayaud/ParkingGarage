package model;

public class Car extends Vehicle{
	
	private CarParkingSpace space;

	public Car(String licensePlateNumber) {
		super(licensePlateNumber);
	}

	public CarParkingSpace getSpace() {
		return space;
	}

	public void setSpace(CarParkingSpace space) {
		this.space = space;
	}
	
}
