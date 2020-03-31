package be.businesstraining;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Example2_LocalDate {
	public static void main(String[] args) {
		
		LocalDate currentLocalDate = LocalDate.now();
	    System.out.println("currentLocalDate - yyyy-MM-dd : " + currentLocalDate);

//	    // Month now not based on 0, and year not based on 1900
//	    LocalDate twentySevenMar2020LocalDate = LocalDate.of(2020, 3, 27);
//	    System.out.println("twentySevenMar2020LocalDate - yyyy-MM-dd : " + twentySevenMar2020LocalDate);
//
//	    twentySevenMar2020LocalDate = twentySevenMar2020LocalDate.withYear(2020).withMonth(3).withDayOfMonth(27);
//	    System.out.println("twentySevenMar2020LocalDate - with :  " + twentySevenMar2020LocalDate);
//
//	    LocalDate parseTwentySevenMar2020LocalDate = LocalDate.parse("2020-03-27", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//	    System.out.println("parseTwentySevenMar2020LocalDate - pattern - yyyy-MM-dd : " + parseTwentySevenMar2020LocalDate);
//	    
//	    // increment using plus, decrement using minus
	    currentLocalDate = currentLocalDate.plusDays(1);
	    System.out.println("twentySevenMar2020LocalDate - immutable : " + currentLocalDate);
		
	}
}
