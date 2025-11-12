package Wrapper.src.com.m;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date01 {
    public static void main(String[] args) {
        Date dt = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss E");

        System.out.println(sdf.format(dt));

    }
}
