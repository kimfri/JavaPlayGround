package org.kimfri.quiz;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneOffset;

/*
 * If line 23 prints "2022-04-18T21:00:00Z"
 * what will line 25 print?
 * The same, since Instant are immutable
 */
import static java.lang.Thread.sleep;

public class Quiz_5 {
    public static void main(String[] args) throws InterruptedException {
        final LocalDate date = LocalDate.of(2022, Month.APRIL, 18);
        final LocalTime time = LocalTime.of(21, 0, 0);
        final LocalDateTime dateTime = LocalDateTime.of(date, time);
        final Instant instant = dateTime.toInstant(ZoneOffset.UTC);
        System.err.println(instant);
        sleep(5000);
        System.err.println(instant);
    }
}
