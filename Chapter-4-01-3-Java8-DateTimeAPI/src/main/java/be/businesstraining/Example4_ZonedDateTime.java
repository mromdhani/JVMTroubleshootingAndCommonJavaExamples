package be.businesstraining;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Example4_ZonedDateTime {

	public static void main(String[] args) {
		ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
		System.out.println("zonedDateTime : " + zonedDateTime);

//		ZoneId europeBrusselsZoneId = ZoneId.of("Europe/Paris");
//		ZonedDateTime europeBrusselsZonedDateTime = ZonedDateTime.of(LocalDateTime.now(), europeBrusselsZoneId);
//		System.out.println("europeBrusselsZonedDateTime : " + europeBrusselsZonedDateTime);

	}

}
