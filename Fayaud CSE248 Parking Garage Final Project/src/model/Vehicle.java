package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class Vehicle {

	private String licensePlateNumber;
	private Date timeAndDate;
	private Attendant checkInAttendant;

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

	
}
