package practice.datetime;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestDateTime {

	
	
	public static void main(String[] args) {
		
		LocalDate date = LocalDate.of(2019, 2, 12);
		
		System.out.println( date.format(DateTimeFormatter.ISO_DATE));
		System.out.println( date.format(DateTimeFormatter.BASIC_ISO_DATE));
		System.out.println( date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		//创建时区
		ZoneId  zoneId = ZoneId.of("Asia/Shanghai");
		
		ZonedDateTime zoneDateTime = date.atStartOfDay(zoneId);
		
		System.out.println( zoneDateTime);
		
	}
}
