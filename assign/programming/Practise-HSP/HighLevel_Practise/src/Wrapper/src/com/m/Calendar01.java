package Wrapper.src.com.m;

import java.util.Calendar;
import java.util.Date;

public class Calendar01 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        System.out.println(calendar.get(Calendar.YEAR));

        System.out.println(calendar.get(Calendar.YEAR) + " "+ calendar.get(Calendar.MONTH) + " " + calendar.get(Calendar.HOUR_OF_DAY)+" "+ calendar.get(Calendar.SECOND));

    }
}
