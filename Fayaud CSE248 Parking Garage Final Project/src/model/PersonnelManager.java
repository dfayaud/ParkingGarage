package model;

public class PersonnelManager {
	
	private Attendant[] attendants;
	private String managerPassword = "123456";
	private int nElems;
	
	public PersonnelManager() {
		this.attendants = new Attendant[10];
	}

	public void addAttendant(String attendantName, String attendantPassword) {
		Attendant attendant = new Attendant(attendantName, attendantPassword);
		attendants[nElems++] = attendant;
	
	}

	
	public Attendant[] getAttendants() {
		return attendants;
	}

	public void setAttendants(Attendant[] attendants) {
		this.attendants = attendants;
	}

	public String getManagerPassword() {
		return managerPassword;
	}

	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}

	public int getnElems() {
		return nElems;
	}

	public void setnElems(int nElems) {
		this.nElems = nElems;
	}
	
	
}
