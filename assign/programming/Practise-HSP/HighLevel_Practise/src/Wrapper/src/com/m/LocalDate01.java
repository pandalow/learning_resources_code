package Wrapper.src.com.m;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDate01 {
    public static void main(String[] args) {
        // Localdate (date/Y M D), LocalTime(TIME/ second hour minutes). LocalDateTime(ALL)

        LocalDateTime ldt = LocalDateTime.now();
        ldt.getHour();
        ldt.getYear();
        ldt.getMinute();


    }
}
