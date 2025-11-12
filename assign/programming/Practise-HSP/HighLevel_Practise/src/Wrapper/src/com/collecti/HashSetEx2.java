package Wrapper.src.com.collecti;

import java.util.HashSet;
import java.util.Objects;

public class HashSetEx2 {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add(new Employees("zhuang",33.25,new Employees.MyDate(2024,10,23)));
        set.add(new Employees("zhuang",43.25,new Employees.MyDate(2024,10,23)));

        System.out.println(set);

    }

}

class Employees{
    private String name;
    private double sal;

    private MyDate myDate;

    public Employees(String name, double sal, MyDate myDate) {
        this.name = name;
        this.sal = sal;
        this.myDate = myDate;
    }

    public String getName() {
        return name;
    }

    public double getSal() {
        return sal;
    }

    public MyDate getMyDate() {
        return myDate;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Employees employees = (Employees) object;
        return Objects.equals(name, employees.name) && Objects.equals(myDate, employees.myDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, myDate);
    }

    static class MyDate{
        private int year;
        private int month;
        private int day;

        public MyDate(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            MyDate myDate = (MyDate) object;
            return year == myDate.year && month == myDate.month && day == myDate.day;
        }

        @Override
        public int hashCode() {
            return Objects.hash(year, month, day);
        }

        public int getYear() {
            return year;
        }

        public int getMonth() {
            return month;
        }

        public int getDay() {
            return day;
        }

    }
}
