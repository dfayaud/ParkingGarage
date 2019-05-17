package model;

public abstract class Vehicle {
	
	private String licensePlateNumber;
	private String color;
	private int vehicleClass;
	private int spaceNumber;
	private Attendant checkInAttendant;
	
	public Vehicle(String licensePlateNumber, String color, Attendant checkInAttendant, int vehicleClass, int spaceNumber) {
		super();
		this.licensePlateNumber = licensePlateNumber;
		this.color = color;
		this.vehicleClass = vehicleClass;
		this.spaceNumber = assignSpaceNumber(vehicleClass);
	}
	
	private int assignSpaceNumber(int vehicleClass) {
		
		return 0;
	}

	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}
	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

}
