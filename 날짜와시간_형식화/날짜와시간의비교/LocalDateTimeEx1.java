package 날짜와시간_형식화.날짜와시간의비교;

import java.time.*;
import java.time.temporal.ChronoField;

public class LocalDateTimeEx1 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2015,12,31);
        LocalTime time = LocalTime.of(12,23,43);

        LocalDateTime dt = LocalDateTime.of(date, time);
        LocalDateTime dt2 = date.atTime(time);
        LocalDateTime dt3 = time.atDate(date);
        LocalDateTime dt4 = date.atTime(12,34,56);
        LocalDateTime dt5 = time.atDate(LocalDate.of(2015,12,31));
        LocalDateTime dt6 = date.atStartOfDay();

        System.out.println("dt = "+dt);
        System.out.println("dt2 = "+dt2);
        System.out.println("dt3 = "+dt3);
        System.out.println("dt4 = "+dt4);
        System.out.println("dt5 = "+dt5);
        System.out.println("dt6 = "+dt6);

        //LocalDateTime의 변환
        LocalDateTime dt7 = LocalDateTime.of(2015,12,31,12,34,56);
        LocalDate date2 = dt.toLocalDate();
        LocalTime time2 = dt.toLocalTime();

        System.out.println("dt7 = " + dt7 + ", date2 = " + date2 + ", time2 = " + time2);

        //LocalDateTime으로 ZonedDateTime만들기
        ZoneId zid = ZoneId.of("Asia/Seoul");
        ZonedDateTime zdt = dt.atZone(zid);
        System.out.println("zdt = "+zdt);

        zdt = LocalDate.now().atStartOfDay(zid);
        System.out.println("New zdt = " +zdt);

        //ZoneOffset
        ZoneOffset krOffset = ZonedDateTime.now().getOffset();
        int krOffsetInSec = krOffset.get(ChronoField.OFFSET_SECONDS);//(32400초 = 60 x 60 x 9)

        System.out.println("krOffset = "+ krOffset +", krOffsetInSec = " + krOffsetInSec);
    }
}
