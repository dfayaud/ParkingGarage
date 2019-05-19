package model;

public class Garage {
	
	private LotManager lotManager;
	private ParkingSpaceStackManager stackManager;
	private PersonnelManager personnelManager;
	private TicketManager ticketManager;
	
	public Garage() {
		super();
		
	}
	
	

	public LotManager getLotManager() {
		return lotManager;
	}

	public void setLotManager(LotManager lotManager) {
		this.lotManager = lotManager;
	}

	public ParkingSpaceStackManager getStackManager() {
		return stackManager;
	}

	public void setStackManager(ParkingSpaceStackManager stackManager) {
		this.stackManager = stackManager;
	}

	public PersonnelManager getPersonnelManager() {
		return personnelManager;
	}

	public void setPersonnelManager(PersonnelManager personnelManager) {
		this.personnelManager = personnelManager;
	}
	
	

}
