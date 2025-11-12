package Wrapper.src.com.m;

import java.util.*;
import java.util.stream.Stream;

public class SystemEx {
    public static void main(String[] args) {
        Double[] nums1 = new Double[]{1.1,2.2,3.3,4.2,5.0};
        Double[] nums2 = new Double[10];
        System.arraycopy(nums1,0,nums2,3,5);
        Arrays.stream(nums2).forEach(aDouble -> System.out.println(aDouble));

        List<Double> list = Arrays.asList(nums2);
//        for (int i = 0; i < nums2.length; i++) {
//            list.add(nums2[i]);
//        }
        try {
            list.stream().sorted(new Comparator<Double>() {
                @Override
                public int compare(Double o1, Double o2) {
                    if(o1 == null||o2 == null) return 0;
                    if(o1 > o2) return 1;
                    else return -1;
                }
            }).filter(e -> e!= null && e.equals(2.2)).forEach(System.out::println);
        }catch(Exception e){
            e.printStackTrace();
        }

        long time = System.currentTimeMillis();
        System.out.println(time);
    }
}
