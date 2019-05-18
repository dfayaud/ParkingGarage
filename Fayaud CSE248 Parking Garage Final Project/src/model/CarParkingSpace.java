package model;

public class CarParkingSpace extends ParkingSpace {

	private final int CAR_SPACE_WIDTH = 10;
	private final int CAR_SPACE_LENGTH = 14;

	public CarParkingSpace(String spaceNumber) {
		super(spaceNumber);
	}

	public int getCAR_SPACE_WIDTH() {
		return CAR_SPACE_WIDTH;
	}

	public int getCAR_SPACE_LENGTH() {
		return CAR_SPACE_LENGTH;
	}


}
