package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

class TicketManagerTest {

	@Test
	void generateEarlyBirdCarTicketTest() {
		TicketManager tm = new TicketManager();
		Date date = Calendar.getInstance().getTime();
		date.setHours(5);
		String s = tm.generateParkingTicket("Doug", "3405875N", date, "C - A1");
		System.out.println(s);
	}
	
	@Test
	void generateEarlyBirdTruckTicketTest() {
		TicketManager tm = new TicketManager();
		Date date = Calendar.getInstance().getTime();
		date.setHours(5);
		String s = tm.generateParkingTicket("Doug", "OEJFG678", date, "T - A1");
		System.out.println(s);
	}
	
	@Test
	void generateEarlyBirdMotorcycleTicketTest() {
		TicketManager tm = new TicketManager();
		Date date = Calendar.getInstance().getTime();
		date.setHours(5);
		String s = tm.generateParkingTicket("Doug", "SDG3RIW", date, "M - A1");
		System.out.println(s);
	}
	
	@Test
	void generateCarTicketTest() {
		TicketManager tm = new TicketManager();
		Date date = Calendar.getInstance().getTime();
		String s = tm.generateParkingTicket("Dohhug", "S486587W", date, "C - A1");
		System.out.println(s);
	}
	
	@Test
	void generateTruckTicketTest() {
		TicketManager tm = new TicketManager();
		Date date = Calendar.getInstance().getTime();
		String s = tm.generateParkingTicket("Doug", "DH3939RIW", date, "T - A1");
		System.out.println(s);
	}

	@Test
	void generateEarlyBirdMotorcycleReceiptTest() {
		TicketManager tm = new TicketManager();
		Date checkInDate = Calendar.getInstance().getTime();
		checkInDate.setHours(14);
		checkInDate.setDate(17);
		String s = tm.generateReceipt("Doug", "Brian", "T45TTRIW", checkInDate, "M - A1");
		System.out.println(s);
	}
	
	@Test
	void generateMotorcycleReceiptTest() {
		TicketManager tm = new TicketManager();
		Date checkInDate = Calendar.getInstance().getTime();
		checkInDate.setHours(19);
		checkInDate.setDate(17);
		String s = tm.generateReceipt("Doug", "Brian", "SWHF87RIW", checkInDate, "M - A1");
		System.out.println(s);
	}
	
	@Test
	void generateEarlyBirdCarReceiptTest() {
		TicketManager tm = new TicketManager();
		Date checkInDate = Calendar.getInstance().getTime();
		checkInDate.setHours(14);
		checkInDate.setDate(17);
		String s = tm.generateReceipt("Doug", "Brian", "P2345785IW", checkInDate, "C - A1");
		System.out.println(s);
	}
	
	@Test
	void generateCarReceiptTest() {
		TicketManager tm = new TicketManager();
		Date checkInDate = Calendar.getInstance().getTime();
		checkInDate.setHours(19);
		checkInDate.setDate(17);
		String s = tm.generateReceipt("Doug", "Brian", "SOKIGHFIW", checkInDate, "C - A1");
		System.out.println(s);
	}
	
	@Test
	void generateEarlyBirdTruckReceiptTest() {
		TicketManager tm = new TicketManager();
		Date checkInDate = Calendar.getInstance().getTime();
		checkInDate.setHours(14);
		checkInDate.setDate(17);
		String s = tm.generateReceipt("Doug", "Brian", "370KGFW", checkInDate, "T - A1");
		System.out.println(s);
	}
	
	@Test
	void generateTruckReceiptTest() {
		TicketManager tm = new TicketManager();
		Date checkInDate = Calendar.getInstance().getTime();
		checkInDate.setHours(19);
		checkInDate.setDate(17);
		String s = tm.generateReceipt("Doug", "Brian", "56JGFIW", checkInDate, "T - A1");
		System.out.println(s);
	}
	
	
}
