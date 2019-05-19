package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Garage implements Serializable{

	private LotManager lotManager;
	private PersonnelManager personnelManager;
	private TicketManager ticketManager;
	private VehicleManager vehicleManager;

	public TicketManager getTicketManager() {
		return ticketManager;
	}

	public void setTicketManager(TicketManager ticketManager) {
		this.ticketManager = ticketManager;
	}

	public VehicleManager getVehicleManager() {
		return vehicleManager;
	}

	public void setVehicleManager(VehicleManager vehicleManager) {
		this.vehicleManager = vehicleManager;
	}

	public Garage() {
		super();
		this.ticketManager = new TicketManager();
	}
	
	public Garage(Garage garage) {
		this.lotManager = garage.lotManager;
		this.personnelManager = garage.personnelManager;
		this.ticketManager = garage.ticketManager;
		this.vehicleManager = garage.vehicleManager;
	}

	public LotManager getLotManager() {
		return lotManager;
	}

	public void setLotManager(LotManager lotManager) {
		this.lotManager = lotManager;
	}


	public PersonnelManager getPersonnelManager() {
		return personnelManager;
	}

	public void setPersonnelManager(PersonnelManager personnelManager) {
		this.personnelManager = personnelManager;
	}

	public void checkInVehicle(String license, String attendantName, int vehicleCode) {
		vehicleManager.insertVehicle(license, vehicleCode, personnelManager.getAttendants().get(attendantName));
		if (vehicleCode == 0) {
			vehicleManager.getVehicleMap().get(license).setSpace(getLotManager().getStackManager().getCarSpaceStack().pop());
			vehicleManager.getVehicleMap().get(license).setSpace(getLotManager().getStackManager().getCarSpaceStack().pop());
		}
		if (vehicleCode == 1) {
			vehicleManager.getVehicleMap().get(license).setSpace(getLotManager().getStackManager().getTruckSpaceStack().pop());
		}
		if (vehicleCode == 2) {
			vehicleManager.getVehicleMap().get(license).setSpace(getLotManager().getStackManager().getMotorcycleSpaceStack().pop());
		}
		ticketManager.generateParkingTicket(attendantName, license,
				vehicleManager.getVehicleMap().get(license).getTimeAndDate(),
				vehicleManager.getVehicleMap().get(license).getSpace().getSpaceNumber());

	}

	public void checkOutVehicle(String license, String checkoutAttendantName) {
		
		if (vehicleManager.getVehicleMap().get(license).getSpace() instanceof CarParkingSpace) {
			getLotManager().getStackManager().getCarSpaceStack()
					.push((CarParkingSpace) vehicleManager.getVehicleMap().get(license).getSpace());
		} else if (vehicleManager.getVehicleMap().get(license).getSpace() instanceof TruckParkingSpace) {
			getLotManager().getStackManager().getTruckSpaceStack()
					.push((TruckParkingSpace) vehicleManager.getVehicleMap().get(license).getSpace());
		} else {
			getLotManager().getStackManager().getMotorcycleSpaceStack()
					.push((MotorcycleParkingSpace) vehicleManager.getVehicleMap().get(license).getSpace());
		}
		ticketManager.generateReceipt(
				vehicleManager.getVehicleMap().get(license).getCheckInAttendant().getAttendantName(),
				checkoutAttendantName, license, vehicleManager.getVehicleMap().get(license).getTimeAndDate(),
				vehicleManager.getVehicleMap().get(license).getSpace().getSpaceNumber());
		vehicleManager.getVehicleMap().remove(license);

	}
	
	public boolean confirmLicenseNumber(String license) {
		if(vehicleManager.getVehicleMap().get(license) != null) {
			return true;
		}
		return false;
	}
	
	public void setupNewLotManager(int length, int width) {
		this.lotManager = new LotManager(new Lot(length, width));
		setupNewPersonnelManager();
		setupNewVehicleManager();
	}
	
	public void setupNewPersonnelManager() {
		this.personnelManager = new PersonnelManager();
	}
	
	public void setupNewVehicleManager() {
		this.vehicleManager = new VehicleManager();
	}

}
