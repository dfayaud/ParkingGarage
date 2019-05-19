package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonnelManagerTest {

	@Test
	void insertAndRetrieveAttendantsTest() {
		PersonnelManager pman = new PersonnelManager();
		pman.addAttendant("Doug", "123456");
		pman.addAttendant("Allen", "0987654");
		pman.addAttendant("Mike", "qwerty");
		
		assertEquals(pman.getAttendants().get("Doug").getAttendantPassword(), "123456");
		assertEquals(pman.getAttendants().get("Allen").getAttendantPassword(), "0987654");
		assertEquals(pman.getAttendants().get("Mike").getAttendantPassword(), "qwerty");
		
		
	}

}
