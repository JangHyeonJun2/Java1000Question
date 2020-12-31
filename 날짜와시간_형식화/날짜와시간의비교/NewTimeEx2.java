package 날짜와시간_형식화.날짜와시간의비교;

import java.time.*;

public class NewTimeEx2 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2015,12,31);
        LocalTime time = LocalTime.of(12,34,56);

        LocalDateTime ldt = LocalDateTime.of(date,time);

        ZoneId zoneId = ZoneId.of("Asia/Seoul");
        ZonedDateTime zdt = ldt.atZone(zoneId);

        ZonedDateTime seoulTime = ZonedDateTime.now();
        ZoneId nyId = ZoneId.of("America/New_York");
        ZonedDateTime nyTime = ZonedDateTime.now().withZoneSameInstant(nyId);

        //ZonedDateTime -> OffsetDateTime
        OffsetDateTime odt = zdt.toOffsetDateTime();

        System.out.println(ldt);
        System.out.println(zoneId);
        System.out.println(zdt);
        System.out.println(seoulTime);
        System.out.println(nyTime);
        System.out.println(odt);
    }
}

