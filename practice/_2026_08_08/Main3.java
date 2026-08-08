package _2026_08_08;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main3 {
    public static void main(String[] args) {
        ZoneId ny = ZoneId.of("America/New_York");
        ZonedDateTime before = ZonedDateTime.of(2026, 3, 8, 1, 30, 0 ,0, ny);

        ZonedDateTime byHours = before.plusHours(24);
        ZonedDateTime byDays = before.plusDays(1);

        System.out.println(byHours);
        System.out.println(byDays);
        System.out.println(byHours.equals(byDays));
    }
}
