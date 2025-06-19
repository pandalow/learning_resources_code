package Wrapper.src.com.collecti;

import java.util.*;

public class MapExercise01 {
    public static void main(String[] args) {
        Map map = new HashMap();
        Employee1 zhuang = new Employee1("zhuang", 13332);
        Employee1 cindy = new Employee1("cindy", 12924);
        map.put(zhuang.getName(), zhuang);
        map.put(cindy.getName(), cindy);

        Collection values = map.values();
        for (Object e : values) {
            System.out.println(e);
        }

        Iterator iterator2 = values.iterator();
        while (iterator2.hasNext()) {
            Employee1 value = (Employee1) iterator2.next();
            if (value.getSal() > 13000) {
                System.out.println(value.name);
            }

        }

        Set keySet = map.keySet();
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next + "-" + map.get(next));
        }

        for (Object e : keySet) {
            System.out.println(e + "-" + map.get(e));
        }


        Set entried = map.entrySet();
        for (Object e : entried) {
            Map.Entry a = (Map.Entry) e;
            System.out.println(a.getKey() + "" + a.getValue());
        }


//        Iterator iterator1 = entried.iterator();
//        while (iterator1.hasNext()) {
//            Map.Entry next = (Map.Entry) iterator.next();
//            System.out.println(next.getKey() + " " +next.getValue());
//        }


    }

    static class Employee1 {
        private String name;
        private double sal;

        public Employee1(String name, double sal) {
            this.name = name;
            this.sal = sal;
        }

        public String getName() {
            return name;
        }

        public double getSal() {
            return sal;
        }
    }

}


