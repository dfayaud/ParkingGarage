package model;

public class Attendant {
	private String attendantName;
	private String attendantPassword;
	
	public Attendant(String attendantName, String attendantPassword) {
		this.attendantName = attendantName;
		this.attendantPassword = attendantPassword;
	}

	public String getAttendantName() {
		return attendantName;
	}

	public void setAttendantName(String attendantName) {
		this.attendantName = attendantName;
	}

	public String getAttendantPassword() {
		return attendantPassword;
	}

	public void setAttendantPassword(String attendantPassword) {
		this.attendantPassword = attendantPassword;
	}

}
