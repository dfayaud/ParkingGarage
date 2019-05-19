package model;

import java.io.Serializable;

public abstract class ParkingSpace implements Serializable{
	private String spaceNumber;
	private int distanceToExit;

	public ParkingSpace(String spaceNumber) {
		super();
		this.spaceNumber = spaceNumber;
	}
	public ParkingSpace() {
		super();
	}

	public int getDistanceToExit() {
		return distanceToExit;
	}

	public void setDistanceToExit(int distanceToExit) {
		this.distanceToExit = distanceToExit;
	}

	public String getSpaceNumber() {
		return spaceNumber;
	}

	public void setSpaceNumber(String spaceNumber) {
		this.spaceNumber = spaceNumber;
	}
	public int compareTo(CarParkingSpace comparestu) {
		return 0;
	}

}
