package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LotManager {
	private Lot lot;
	private ParkingSpaceStackManager stackManager;

	public LotManager(Lot lot) {
		super();
		this.lot = lot;
		this.stackManager = new ParkingSpaceStackManager();
		populateCarParkingSpaces();
		populateTruckParkingSpaces();
		populateMotorcycleParkingSpaces();
		
	}


	public void populateCarParkingSpaces() {
		int carColumns = lot.getCarColumns();
		int carsPerColumn = lot.getLength() / 8;
		int totalCarSpaces = carColumns * carsPerColumn;
		char section = 'A';
		
		ArrayList<ParkingSpace>spaces = new ArrayList<>();
		
		for (int row = 0; row < carColumns; row++) {
			for (int column = 0; column < carsPerColumn; column++) {
				CarParkingSpace space = new CarParkingSpace(section + Integer.toString(column));
				space.setDistanceToExit(calculateDistanceToExit(row, column, 0));	
				spaces.add(space);
			}
			section++;
		}
		Collections.sort(spaces, new Comparator<ParkingSpace>() {
	        public int compare(ParkingSpace p1, ParkingSpace p2) {
	           return Integer.valueOf(p2.getDistanceToExit() - p1.getDistanceToExit());
	        }
	});
		for(ParkingSpace e: spaces) {
			stackManager.getCarSpaceStack().push((CarParkingSpace) e);
		}
	}
	
	public void populateTruckParkingSpaces() {
		int truckColumns = lot.getTruckColumns();
		int trucksPerColumn = lot.getLength() / 10;
		int totalTruckSpaces = truckColumns * trucksPerColumn;
		char section = 'A';
		
		ArrayList<TruckParkingSpace>spaces = new ArrayList<>();
		
		for (int row = 0; row < truckColumns; row++) {
			for (int column = 0; column < trucksPerColumn; column++) {
				TruckParkingSpace space = new TruckParkingSpace(section + Integer.toString(column));
				space.setDistanceToExit(calculateDistanceToExit(row, column, 1));
				spaces.add(space);
			}
			section++;
		}
		Collections.sort(spaces, new Comparator<ParkingSpace>() {
	        public int compare(ParkingSpace p1, ParkingSpace p2) {
	           return Integer.valueOf(p2.getDistanceToExit() - p1.getDistanceToExit());
	        }
	});
		for(TruckParkingSpace e: spaces) {
			stackManager.getTruckSpaceStack().push(e);
		}
	}
	
	public void populateMotorcycleParkingSpaces() {
		int motorcycleColumns = lot.getMotorcycleColumns();
		int motorcyclesPerColumn = lot.getLength() / 10;
		int totalTruckSpaces = motorcycleColumns * motorcyclesPerColumn;
		char section = 'A';
		
		ArrayList<MotorcycleParkingSpace>spaces = new ArrayList<>();
		
		for (int row = 0; row < motorcycleColumns; row++) {
			for (int column = 0; column < motorcyclesPerColumn; column++) {
				MotorcycleParkingSpace space = new MotorcycleParkingSpace(Integer.toString(column) + section);
				space.setDistanceToExit(calculateDistanceToExit(row, column, 2));		
				spaces.add(space);
			}
			section++;
		}
		Collections.sort(spaces, new Comparator<ParkingSpace>() {
	        public int compare(ParkingSpace p1, ParkingSpace p2) {
	           return Integer.valueOf(p2.getDistanceToExit() - p1.getDistanceToExit());
	        }
	});
		for(MotorcycleParkingSpace e: spaces) {
			stackManager.getMotorcycleSpaceStack().push(e);
		}
	}

	private int calculateDistanceToExit(int row, int column, int vehicleCode) {
		if (vehicleCode == 0) {
			row = row * lot.getSECTION_WIDTH();
			column = 8*column;
		} else if (vehicleCode == 1) {
			row = lot.getCAR_COLUMN_WIDTH() + lot.getLANE_WIDTH() + row * lot.getSECTION_WIDTH();
			column = 10*column;
		} else if (vehicleCode == 2) {
			row = lot.getCAR_COLUMN_WIDTH() + lot.getLANE_WIDTH() + lot.getTRUCK_COLUMN_WIDTH()
					+ lot.getMOTORCYCLE_LANE_WIDTH() + row * lot.getSECTION_WIDTH();
			column = 10*column;
		}
		return row + column;
	}
	

	public Lot getLot() {
		return lot;
	}

	public ParkingSpaceStackManager getStackManager() {
		return stackManager;
	}

}
