package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	void checkInTimeTest() {
		Car car = new Car("werd5678");
		Date date = Calendar.getInstance().getTime();
		int diffInDays = (int)( (date.getTime() - car.getTimeAndDate().getTime()) 
                / (1000 * 60 * 60 * 24) );
		System.out.println(diffInDays);
	}
	
	

}
