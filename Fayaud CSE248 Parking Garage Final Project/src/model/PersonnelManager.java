package model;

import java.util.HashMap;
import java.util.HashSet;

public class PersonnelManager {

	private HashMap<String, Attendant> attendants;
	private final String MANAGER_PASSWORD = "123456";

	public PersonnelManager() {
		this.attendants = new HashMap<String, Attendant>();
	}

	public void addAttendant(String attendantName, String attendantPassword) {
		Attendant attendant = new Attendant(attendantName, attendantPassword);
		attendants.put(attendantName, attendant);

	}

	public HashMap<String, Attendant> getAttendants() {
		return attendants;
	}

	public void setAttendants(HashMap<String, Attendant> attendants) {
		this.attendants = attendants;
	}

	public String getMANAGER_PASSWORD() {
		return MANAGER_PASSWORD;
	}

}
