package model;

import java.io.Serializable;
import java.util.HashMap;

public class VehicleManager implements Serializable {
	
	private HashMap<String, Vehicle> vehicleMap;

	public VehicleManager() {
		super();
		this.vehicleMap = new HashMap<String, Vehicle>();
	}

	public HashMap<String, Vehicle> getVehicleMap() {
		return vehicleMap;
	}

	public void setVehicleMap(HashMap<String, Vehicle> vehicleMap) {
		this.vehicleMap = vehicleMap;
	}
	
	public void insertVehicle(String licensePlate, int vehicleCode, Attendant attendant) {
		if(vehicleCode == 0) {
			Car car = new Car(licensePlate);
			car.setCheckInAttendant(attendant);
			vehicleMap.put(licensePlate, car);
		}
		if(vehicleCode == 1) {
			Truck truck = new Truck(licensePlate);
			truck.setCheckInAttendant(attendant);
			vehicleMap.put(licensePlate, truck);
		}
		if(vehicleCode == 2) {
			Motorcycle motorcycle = new Motorcycle(licensePlate);
			motorcycle.setCheckInAttendant(attendant);
			vehicleMap.put(licensePlate, motorcycle);
		}
		
	}

}
