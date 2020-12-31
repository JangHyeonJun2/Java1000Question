package 날짜와시간_형식화.TemporalAdjustersEx1;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class BetweenEx1 {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2017,1,1);
        LocalDate date2 = LocalDate.of(2015,12,31);

        LocalTime time1 = LocalTime.of(00,00,00);
        LocalTime time2 = LocalTime.of(12,34,56);

        Period pe = Period.between(date1, date2);
        System.out.println(pe);

//        int year = pe.getYears();
//        int days = pe.getDays();
//        int month = pe.getMonths();
        /* 위에 int 식과 결과는 똑같다.! */
        long year = pe.get(ChronoUnit.YEARS);
        long month = pe.get(ChronoUnit.MONTHS);
        long days = pe.get(ChronoUnit.DAYS);


        System.out.println("년 = " + year + "달 = " + month + "일 = " + days);

        Duration du = Duration.between(time1,time2);
        System.out.println(du);

        /*
         * Period와 달리 Duration에는 getHours(), getMinites()같은 메서드가 없다.
         * System.out.println(du.getUnits()); [Seconds, Nanos]
         * 그래서! Duration을 LocalTime으로 변환한 다음에, LocalTime이 가지고 있는 get메서드를 사용하면 더 간단하다.
         */

        LocalTime tmpTime = LocalTime.of(0,0).plusSeconds(du.getSeconds());

        int hour = tmpTime.getHour();
        int min = tmpTime.getMinute();
        int second = tmpTime.getSecond();
        int nano = du.getNano();
    }
}
