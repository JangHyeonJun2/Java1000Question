package 날짜와시간_형식화.파싱과포맷;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateFormatterEx2 {
    public static void main(String[] args) {
        LocalDate newYear = LocalDate.parse("2020-08-04", DateTimeFormatter.ISO_LOCAL_DATE);

        LocalDate date = LocalDate.parse("2001-01-01");
        LocalTime time = LocalTime.parse("23:59:59");
        LocalDateTime dateTime = LocalDateTime.parse("2001-01-01T23:03:03");

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime endOfYear = LocalDateTime.parse("2014-12-31 23:23:34",pattern);
        System.out.println(newYear);
        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);
        System.out.println(endOfYear);
    }
}
