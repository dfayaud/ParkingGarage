package model;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

public class TicketManager implements Serializable {
	private String checkInAttendant;
	private Date checkInTimeAndDate;
	private Date checkOutTimeAndDate;
	private String licensePlateNumber;
	private final String SPACE_NUMBER = "\n\nSPACE NO.: ";
	private final String TICKET_HEADER = "WELCOME TO CARPORTAL";
	private final String STAR_LINE = "\n\n**************************\n";
	private final String LICENSE_NUMBER = "\n\nLICENSE PLATE NO.: ";
	private final String CHECKIN_TIME = "\nCHECK-IN: ";
	private final String CHECKOUT_TIME = "\nCHECK-OUT: ";
	private final String RATE = "\n\nRATE: ";
	private final String CAR_RATE = "$2.50 Per Hour";
	private final String TRUCK_RATE = "$5.00 Per Hour";
	private final String MOTORCYCLE_RATE = "$1.00 Per Hour";
	private final String CAR_EARLY_BIRD = "$20.00, Early Bird Rate";
	private final String TRUCK_EARLY_BIRD = "$40.00, Early Bird Rate";
	private final String MOTORCYCLE_EARLY_BIRD = "$10.00, Early Bird Rate";
	private final String TOTAL_HOURS = "TOTAL HOURS: ";
	private final String TOTAL_DUE = "\n\nTOTAL DUE: ";
	private final String CHECKIN_ATTENDANT_NAME = "\nCHECK-IN ATTENDANT: ";
	private final String CHECKOUT_ATTENDANT_NAME = "\nCHECK-OUT ATTENDANT: ";
	private final String RECEIPT_HEADER = "\n\nTHANK YOU FOR USING CARPORTAL";
	DecimalFormat df = new DecimalFormat("$#.00");

	public TicketManager() {

	}

	public String generateParkingTicket(String checkInAttendant, String licensePlateNumber, Date checkInTimeAndDate,
			String spaceNumber) {
		String[] ticketArray = { TICKET_HEADER, " ", " ", STAR_LINE, " ", " ",
				CHECKIN_ATTENDANT_NAME + checkInAttendant, " ", " ", LICENSE_NUMBER + licensePlateNumber, " ", " ",
				SPACE_NUMBER + spaceNumber, " ", " ", RATE + calculateRate(checkInTimeAndDate, spaceNumber), " ", " ",
				CHECKIN_TIME + checkInTimeAndDate, " ", " ", STAR_LINE };
		String ticket = TICKET_HEADER + STAR_LINE + CHECKIN_ATTENDANT_NAME + checkInAttendant + CHECKIN_TIME
				+ checkInTimeAndDate + LICENSE_NUMBER + licensePlateNumber + SPACE_NUMBER + spaceNumber + RATE
				+ calculateRate(checkInTimeAndDate, spaceNumber) + CHECKIN_TIME + checkInTimeAndDate + STAR_LINE;
		exportTicket(ticketArray, licensePlateNumber);
		return ticket;

	}

	public String generateReceipt(String checkInAttendant, String checkOutAttendant, String licensePlateNumber,
			Date checkInTimeAndDate, String spaceNumber) {
		Date currentDateAndTime = Calendar.getInstance().getTime();
		int totalHours = (int) ((currentDateAndTime.getTime() - checkInTimeAndDate.getTime()) / (1000 * 60 * 60));

		String[] receiptArray = { RECEIPT_HEADER, " ", " ", STAR_LINE, " ", " ",
				CHECKIN_ATTENDANT_NAME + checkInAttendant, " ", " ", CHECKOUT_ATTENDANT_NAME + checkOutAttendant, "",
				"", LICENSE_NUMBER + licensePlateNumber, " ", " ", SPACE_NUMBER + spaceNumber, " ", " ",
				RATE + calculateRate(checkInTimeAndDate, spaceNumber), " ", " ", CHECKIN_TIME + checkInTimeAndDate, " ", " ",
				CHECKOUT_TIME + Calendar.getInstance().getTime(), " ", " ", TOTAL_HOURS + totalHours + " ", " ", 
				TOTAL_DUE + calculateTotalDue(checkInTimeAndDate, spaceNumber), " ", " ", STAR_LINE };
		String receipt = RECEIPT_HEADER + STAR_LINE + CHECKIN_ATTENDANT_NAME + checkInAttendant
				+ CHECKOUT_ATTENDANT_NAME + checkOutAttendant + LICENSE_NUMBER + licensePlateNumber + SPACE_NUMBER
				+ spaceNumber + RATE + calculateRate(checkInTimeAndDate, spaceNumber) + TOTAL_DUE
				+ calculateTotalDue(checkInTimeAndDate, spaceNumber) + STAR_LINE;
		exportReceipt(receiptArray, licensePlateNumber);
		return receipt;

	}

	private String calculateTotalDue(Date checkInTimeAndDate, String spaceNumber) {
		String due = "";
		Date currentDateAndTime = Calendar.getInstance().getTime();
		int totalHours = (int) ((currentDateAndTime.getTime() - checkInTimeAndDate.getTime()) / (1000 * 60 * 60));

		if (checkInTimeAndDate.getHours() < 18 && spaceNumber.charAt(0) == 'C') {
			due = CAR_EARLY_BIRD;
		} else if (checkInTimeAndDate.getHours() >= 18 && spaceNumber.charAt(0) == 'C') {
			due = df.format((totalHours + 1) * 2.50);
		} else if (checkInTimeAndDate.getHours() < 18 && spaceNumber.charAt(0) == 'T') {
			due = TRUCK_EARLY_BIRD;
		} else if (checkInTimeAndDate.getHours() >= 18 && spaceNumber.charAt(0) == 'T') {
			due = df.format((totalHours + 1) * 5.00);
		} else if (checkInTimeAndDate.getHours() < 18 && spaceNumber.charAt(0) == 'M') {
			due = MOTORCYCLE_EARLY_BIRD;
		} else {
			due = df.format(((totalHours + 1) * 1.00));
		}
		return due;
	}

	private String calculateRate(Date checkInTimeAndDate, String spaceNumber) {

		String rate = "";
		if (checkInTimeAndDate.getHours() < 18 && spaceNumber.charAt(0) == 'C') {
			rate = CAR_EARLY_BIRD;
		} else if (checkInTimeAndDate.getHours() >= 18 && spaceNumber.charAt(0) == 'C') {
			rate = CAR_RATE;
		} else if (checkInTimeAndDate.getHours() < 18 && spaceNumber.charAt(0) == 'T') {
			rate = TRUCK_EARLY_BIRD;
		} else if (checkInTimeAndDate.getHours() >= 18 && spaceNumber.charAt(0) == 'T') {
			rate = TRUCK_RATE;
		} else if (checkInTimeAndDate.getHours() < 18 && spaceNumber.charAt(0) == 'M') {
			rate = MOTORCYCLE_EARLY_BIRD;
		} else {
			rate = MOTORCYCLE_RATE;
		}
		return rate;
	}

	public void exportTicket(String[] ticket, String licenseNumber) {
		PrintWriter pr = null;
		try {
			pr = new PrintWriter(licenseNumber + "_ticket.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (String e : ticket) {
			pr.println(e);
		}
		pr.close();
	}

	public void exportReceipt(String[] receipt, String licenseNumber) {
		PrintWriter pr = null;
		try {
			pr = new PrintWriter(licenseNumber + "_receipt.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (String e : receipt) {
			pr.println(e);
		}
		pr.close();
	}
}
