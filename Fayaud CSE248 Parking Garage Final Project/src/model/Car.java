package model;

public class Car extends Vehicle{
	
	private CarParkingSpace space;

	public Car(String licensePlateNumber, String color, Attendant checkInAttendant) {
		super(licensePlateNumber, color, checkInAttendant);
	}

}
