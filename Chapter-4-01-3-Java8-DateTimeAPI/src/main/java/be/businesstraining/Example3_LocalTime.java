package be.businesstraining;

import java.time.LocalTime;

public class Example3_LocalTime {
	public static void main(String[] args) {

		// Time with no date
		LocalTime currentLocalTime = LocalTime.now();
		System.out.println("currentLocalTime - yyyy-MM-dd : " + currentLocalTime);

		LocalTime parseLocalTime = LocalTime.parse("13:44");
		System.out.println("parseLocalTime : " + parseLocalTime);

		parseLocalTime = LocalTime.parse("13:44:25");
		System.out.println("parseLocalTime - immutable : " + parseLocalTime);
	}
}
