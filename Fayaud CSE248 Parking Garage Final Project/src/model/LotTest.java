package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LotTest {

	@Test
	void minimumLotAWidthTest() {
		Lot lot = new Lot(100, 38);
		assertEquals(lot.getCarColumns(), 1);
		assertEquals(lot.getTruckColumns(), 0);
		assertEquals(lot.getMotorcycleColumns(), 0);
	}
	@Test
	void minimumLotBWidthTest() {
		Lot lot = new Lot(100, 56);
		assertEquals(lot.getCarColumns(), 1);
		assertEquals(lot.getTruckColumns(), 1);
		assertEquals(lot.getMotorcycleColumns(), 0);
	}
	
	@Test
	void minimumFullSectionWidthTest() {
		Lot lot = new Lot(100, 64);
		assertEquals(lot.getCarColumns(), 1);
		assertEquals(lot.getTruckColumns(), 1);
		assertEquals(lot.getMotorcycleColumns(), 1);
	}
	@Test
	void minimumFullSectionAWidthTest() {
		Lot lot = new Lot(100, 102);
		assertEquals(lot.getCarColumns(), 2);
		assertEquals(lot.getTruckColumns(), 1);
		assertEquals(lot.getMotorcycleColumns(), 1);
	}
	@Test
	void minimumFullSectionBWidthTest() {
		Lot lot = new Lot(100, 120);
		assertEquals(lot.getCarColumns(), 2);
		assertEquals(lot.getTruckColumns(), 2);
		assertEquals(lot.getMotorcycleColumns(), 1);
	}
	@Test
	void multipleFullSectionsWidthTest() {
		Lot lot = new Lot(100, 2000);
		assertEquals(lot.getCarColumns(), 31);
		assertEquals(lot.getTruckColumns(), 31);
		assertEquals(lot.getMotorcycleColumns(), 31);
	}
}
