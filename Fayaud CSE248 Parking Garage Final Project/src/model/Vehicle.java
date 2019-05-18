package model;

public abstract class Vehicle {

	private String licensePlateNumber;
	private String color;
	private Attendant checkInAttendant;

	public Vehicle(String licensePlateNumber, String color, Attendant checkInAttendant) {
		super();
		this.licensePlateNumber = licensePlateNumber;
		this.color = color;
		this.checkInAttendant = checkInAttendant;
	}

	public Attendant getCheckInAttendant() {
		return checkInAttendant;
	}

	public void setCheckInAttendant(Attendant checkInAttendant) {
		this.checkInAttendant = checkInAttendant;
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
