package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GarageTest {

	@Test
	void initialLotSetupTest() {
		Garage garage = new Garage();
		garage.setupNewLotManager(100, 100);
		assertEquals(garage.getLotManager().getStackManager().getCarSpaceStack().size(), 12);
		assertEquals(garage.getLotManager().getStackManager().getTruckSpaceStack().size(), 10);
		assertEquals(garage.getLotManager().getStackManager().getMotorcycleSpaceStack().size(), 10);
	}
	
	@Test
	void initialLotSetupAndPersonnelSetupTest() {
		Garage garage = new Garage();
		garage.setupNewLotManager(100, 100);
		assertEquals(garage.getLotManager().getStackManager().getCarSpaceStack().size(), 12);
		assertEquals(garage.getLotManager().getStackManager().getTruckSpaceStack().size(), 10);
		assertEquals(garage.getLotManager().getStackManager().getMotorcycleSpaceStack().size(), 10);

		garage.getPersonnelManager().addAttendant("Eddie", "dfrtyu");
		garage.getPersonnelManager().addAttendant("Bill", "123ertyv");
		garage.getPersonnelManager().addAttendant("Sarah", "fiyk565");
		
		assertEquals(garage.getPersonnelManager().getAttendants().get("Eddie").getAttendantPassword(), "dfrtyu");
		assertEquals(garage.getPersonnelManager().getAttendants().get("Bill").getAttendantPassword(), "123ertyv");
		assertEquals(garage.getPersonnelManager().getAttendants().get("Sarah").getAttendantPassword(), "fiyk565");
		
	}
	
	@Test
	void initialLotSetupAndPersonnelSetupAndFirstVehiclesTest() {
		Garage garage = new Garage();
		garage.setupNewLotManager(100, 100);
		assertEquals(garage.getLotManager().getStackManager().getCarSpaceStack().size(), 12);
		assertEquals(garage.getLotManager().getStackManager().getTruckSpaceStack().size(), 10);
		assertEquals(garage.getLotManager().getStackManager().getMotorcycleSpaceStack().size(), 10);

		garage.getPersonnelManager().addAttendant("Eddie", "dfrtyu");
		garage.getPersonnelManager().addAttendant("Bill", "123ertyv");
		garage.getPersonnelManager().addAttendant("Sarah", "fiyk565");
		
		assertEquals(garage.getPersonnelManager().getAttendants().get("Eddie").getAttendantPassword(), "dfrtyu");
		assertEquals(garage.getPersonnelManager().getAttendants().get("Bill").getAttendantPassword(), "123ertyv");
		assertEquals(garage.getPersonnelManager().getAttendants().get("Sarah").getAttendantPassword(), "fiyk565");
		

		
		garage.checkInVehicle("WEIT3456", "Eddie", 0);


		
		garage.checkInVehicle("FRGT3456", "Bill", 1);
		garage.checkInVehicle("EOR44346", "Eddie", 0);
		garage.checkInVehicle("EEOI4885", "Sarah", 1);
		garage.checkInVehicle("WOREOCX1", "Eddie", 0);
		garage.checkInVehicle("PWOECM12", "Sarah", 1);
		garage.checkInVehicle("PWORCN12", "Eddie", 2);
		garage.checkInVehicle("FGFGFG12", "Bill", 0);
		garage.checkInVehicle("PWWOR123", "Eddie", 2);

		
		assertEquals(garage.confirmLicenseNumber("WEIT3456"), true);
		assertEquals(garage.confirmLicenseNumber("FRGT3456"), true);
		assertEquals(garage.confirmLicenseNumber("EOR44346"), true);
		assertEquals(garage.confirmLicenseNumber("EEOI4885"), true);
		assertEquals(garage.confirmLicenseNumber("WOREOCX1"), true);
		assertEquals(garage.confirmLicenseNumber("PWOECM12"), true);
		assertEquals(garage.confirmLicenseNumber("PWORCN12"), true);
		assertEquals(garage.confirmLicenseNumber("FGFGFG12"), true);
		assertEquals(garage.confirmLicenseNumber("PWWOR123"), true);
		
		
	}
	
	@Test
	void initialLotSetupAndPersonnelSetupAndFirstVehiclesAndCheckOutTest() {
		Garage garage = new Garage();
		garage.setupNewLotManager(100, 100);
		assertEquals(garage.getLotManager().getStackManager().getCarSpaceStack().size(), 12);
		assertEquals(garage.getLotManager().getStackManager().getTruckSpaceStack().size(), 10);
		assertEquals(garage.getLotManager().getStackManager().getMotorcycleSpaceStack().size(), 10);
		

		garage.getPersonnelManager().addAttendant("Eddie", "dfrtyu");
		garage.getPersonnelManager().addAttendant("Bill", "123ertyv");
		garage.getPersonnelManager().addAttendant("Sarah", "fiyk565");
		
		assertEquals(garage.getPersonnelManager().getAttendants().get("Eddie").getAttendantPassword(), "dfrtyu");
		assertEquals(garage.getPersonnelManager().getAttendants().get("Bill").getAttendantPassword(), "123ertyv");
		assertEquals(garage.getPersonnelManager().getAttendants().get("Sarah").getAttendantPassword(), "fiyk565");

		
		garage.checkInVehicle("WEIT3456", "Eddie", 0);
	

		
		garage.checkInVehicle("FRGT3456", "Bill", 1);
		garage.checkInVehicle("EOR44346", "Eddie", 0);
		garage.checkInVehicle("EEOI4885", "Sarah", 1);
		garage.checkInVehicle("WOREOCX1", "Eddie", 0);
		garage.checkInVehicle("PWOECM12", "Sarah", 1);
		garage.checkInVehicle("PWORCN12", "Eddie", 2);
		garage.checkInVehicle("FGFGFG12", "Bill", 0);
		garage.checkInVehicle("PWWOR123", "Eddie", 2);

		
		assertEquals(garage.confirmLicenseNumber("WEIT3456"), true);
		assertEquals(garage.confirmLicenseNumber("FRGT3456"), true);
		assertEquals(garage.confirmLicenseNumber("EOR44346"), true);
		assertEquals(garage.confirmLicenseNumber("EEOI4885"), true);
		assertEquals(garage.confirmLicenseNumber("WOREOCX1"), true);
		assertEquals(garage.confirmLicenseNumber("PWOECM12"), true);
		assertEquals(garage.confirmLicenseNumber("PWORCN12"), true);
		assertEquals(garage.confirmLicenseNumber("FGFGFG12"), true);
		assertEquals(garage.confirmLicenseNumber("PWWOR123"), true);
		
		garage.checkOutVehicle("PWWOR123", "Eddie");
		assertEquals(garage.confirmLicenseNumber("PWWOR123"), false);
		
		garage.checkInVehicle("RECHECKIN", "Eddie", 2);
		
	}
	
	
}
