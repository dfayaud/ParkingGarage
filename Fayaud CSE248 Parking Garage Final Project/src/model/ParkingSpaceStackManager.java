package model;

import java.io.Serializable;
import java.util.Stack;

public class ParkingSpaceStackManager implements Serializable {
	
	private Stack <CarParkingSpace> carSpaceStack;
	private Stack <TruckParkingSpace>truckSpaceStack;
	private Stack <MotorcycleParkingSpace> motorcycleSpaceStack;
	
	public ParkingSpaceStackManager() {
		super();
		this.carSpaceStack = new Stack<CarParkingSpace>();
		this.truckSpaceStack = new Stack<TruckParkingSpace>();
		this.motorcycleSpaceStack = new Stack<MotorcycleParkingSpace>();
	}

	public Stack<CarParkingSpace> getCarSpaceStack() {
		return carSpaceStack;
	}

	public void setCarSpaceStack(Stack<CarParkingSpace> carSpaceStack) {
		this.carSpaceStack = carSpaceStack;
	}

	public Stack<TruckParkingSpace> getTruckSpaceStack() {
		return truckSpaceStack;
	}

	public void setTruckSpaceStack(Stack<TruckParkingSpace> truckSpaceStack) {
		this.truckSpaceStack = truckSpaceStack;
	}

	public Stack<MotorcycleParkingSpace> getMotorcycleSpaceStack() {
		return motorcycleSpaceStack;
	}

	public void setMotorcycleSpaceStack(Stack<MotorcycleParkingSpace> motorcycleSpaceStack) {
		this.motorcycleSpaceStack = motorcycleSpaceStack;
	}
	
	
}
