package be.businesstraining;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Example1_Deprecated_Date_Calendar {

	public static void main(String[] args) {
		
		Date today = new Date();
		System.out.println("Note the time includes the default timezone - " + today.toString());

		Date twentySevenFeb2017Date = new Date(119, 1, 27);
		System.out.println("Now deprecated new Date(day, month, year) - but note month starts at zero, and year 1900 - " + twentySevenFeb2017Date);

		Calendar twentySevenFeb2017Calendar = new GregorianCalendar(2019,1,27);
		System.out.println("Calendar - month starts at zero, and but year fixed - " + twentySevenFeb2017Calendar.getTime());

		DateFormat ddMMyyySDF = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("DateFormat not ThreadSafe - " + ddMMyyySDF.format(twentySevenFeb2017Date));
	}

}
