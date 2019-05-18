package model;

public class Lot {

	private int length;
	private int width;
	private String sizeCategory;
	private int motorcycleColumns;
	private int carColumns;
	private int truckColumns;
	private final int CAR_COLUMN_WIDTH = 14;
	private final int LANE_WIDTH = 24;
	private final int TRUCK_COLUMN_WIDTH = 18;
	private final int MOTORCYCLE_COLUMN_WIDTH = 4;
	private final int MOTORCYCLE_LANE_WIDTH = 4;
	private final int SECTION_WIDTH = CAR_COLUMN_WIDTH + LANE_WIDTH + TRUCK_COLUMN_WIDTH + MOTORCYCLE_LANE_WIDTH
			+ MOTORCYCLE_COLUMN_WIDTH;


	public Lot(int length, int width) {
		super();
		this.length = length;
		this.width = width;
		this.sizeCategory = determineSizeCategory(width);
		this.carColumns = calculateCarColumns(sizeCategory);
		this.truckColumns = calculateTruckColumns(sizeCategory);
		this.motorcycleColumns = calculateMotorcycleColumns(sizeCategory);
	}

	public String determineSizeCategory(int width) {
		
		String fullSections = Integer.toString(width / SECTION_WIDTH);
		int remainingSpace = width % SECTION_WIDTH;

		char extraLanes = ' ';

		if (remainingSpace >= (CAR_COLUMN_WIDTH + LANE_WIDTH) && remainingSpace < (CAR_COLUMN_WIDTH + LANE_WIDTH + TRUCK_COLUMN_WIDTH) ) {
			extraLanes = 'A';
		}
		if (remainingSpace >= (CAR_COLUMN_WIDTH + LANE_WIDTH + TRUCK_COLUMN_WIDTH) && remainingSpace < SECTION_WIDTH) {
			extraLanes = 'B';
		}
		
		return fullSections + extraLanes;
	}

	public int calculateCarColumns(String sizeCategory) {
		if (sizeCategory.endsWith("A")||sizeCategory.endsWith("B")) {
			return Integer.parseInt(sizeCategory.replaceAll("[^0-9]", "")) + 1;
		}
		return Integer.parseInt(sizeCategory.replaceAll("[^0-9]", ""));
	}

	public int calculateTruckColumns(String sizeCategory) {
		if (sizeCategory.endsWith("B")) {
			return Integer.parseInt(sizeCategory.replaceAll("[^0-9]", "")) + 1;
		}
		return Integer.parseInt(sizeCategory.replaceAll("[^0-9]", ""));
	}

	public int calculateMotorcycleColumns(String sizeCategory) {
		return Integer.parseInt(sizeCategory.replaceAll("[^0-9]", ""));
	}

	public int getLength() {
		return length;
	}

	public int getWidth() {
		return width;
	}

	public String getSizeCategory() {
		return sizeCategory;
	}

	public int getMotorcycleColumns() {
		return motorcycleColumns;
	}

	public int getCarColumns() {
		return carColumns;
	}

	public int getTruckColumns() {
		return truckColumns;
	}

	public int getCAR_COLUMN_WIDTH() {
		return CAR_COLUMN_WIDTH;
	}

	public int getLANE_WIDTH() {
		return LANE_WIDTH;
	}

	public int getTRUCK_COLUMN_WIDTH() {
		return TRUCK_COLUMN_WIDTH;
	}

	public int getMOTORCYCLE_COLUMN_WIDTH() {
		return MOTORCYCLE_COLUMN_WIDTH;
	}

	public int getMOTORCYCLE_LANE_WIDTH() {
		return MOTORCYCLE_LANE_WIDTH;
	}

	public int getSECTION_WIDTH() {
		return SECTION_WIDTH;
	}
}
