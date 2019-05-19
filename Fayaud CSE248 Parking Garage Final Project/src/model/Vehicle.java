package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class Vehicle implements Serializable {

	private String licensePlateNumber;
	private Date timeAndDate;
	private Attendant checkInAttendant;
	private ParkingSpace space;

	public Vehicle(String licensePlateNumber) {
		super();
		this.licensePlateNumber = licensePlateNumber;
		this.timeAndDate = generateTimeAndDate();
	}

	public Date getTimeAndDate() {
		return timeAndDate;
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

	public Date generateTimeAndDate() {
		Date date = Calendar.getInstance().getTime();
		return date;
	}

	public ParkingSpace getSpace() {
		return space;
	}

	public void setSpace(ParkingSpace space) {
		this.space = space;
	}

	public void setTimeAndDate(Date timeAndDate) {
		this.timeAndDate = timeAndDate;
	}
	

	
}
