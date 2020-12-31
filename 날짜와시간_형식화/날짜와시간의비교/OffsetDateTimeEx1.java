package 날짜와시간_형식화.날짜와시간의비교;

import java.time.*;

public class OffsetDateTimeEx1 {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.now();
        ZoneOffset krOffset = ZonedDateTime.now().getOffset();
        ZoneId zoneId = ZoneId.of("Asia/Seoul");
        ZonedDateTime zonedDateTime = dt.atZone(zoneId);
        OffsetDateTime offsetDateTime = dt.atOffset(krOffset);
        System.out.println(zonedDateTime);
        System.out.println(offsetDateTime);

    }
}
