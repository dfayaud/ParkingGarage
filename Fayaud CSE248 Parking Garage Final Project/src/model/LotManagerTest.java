package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LotManagerTest {

	@Test
	void carPopLotManagerTest() {
		LotManager lotManager = new LotManager(new Lot(100, 200));
		while(!lotManager.getStackManager().getCarSpaceStack().isEmpty()) {
			CarParkingSpace space = lotManager.getStackManager().getCarSpaceStack().pop();
			System.out.println(space.getSpaceNumber() + "  " + space.getDistanceToExit());
		}
	}
	
	@Test
	void truckPopLotManagerTest() {
		LotManager lotManager = new LotManager(new Lot(100, 200));
		while(!lotManager.getStackManager().getTruckSpaceStack().isEmpty()) {
			TruckParkingSpace space = lotManager.getStackManager().getTruckSpaceStack().pop();
			System.out.println(space.getSpaceNumber() + "  " + space.getDistanceToExit());
		}
	}
	
	@Test
	void motorcyclePopLotManagerTest() {
		LotManager lotManager = new LotManager(new Lot(100, 80));
		while(!lotManager.getStackManager().getMotorcycleSpaceStack().isEmpty()) {
			MotorcycleParkingSpace space = lotManager.getStackManager().getMotorcycleSpaceStack().pop();
			System.out.println(space.getSpaceNumber() + "  " + space.getDistanceToExit());
		}
	}


}
