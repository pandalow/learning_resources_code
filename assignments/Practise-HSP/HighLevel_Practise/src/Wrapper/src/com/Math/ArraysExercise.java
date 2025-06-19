package Wrapper.src.com.Math;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArraysExercise {
    public static void main(String[] args) {
        Integer[] integers = {1, 20, 90};
        System.out.println(Arrays.toString(integers));

        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        ArraysExercise.bubble(integers, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                return i2-i1;
            }
        });

        Arrays.binarySearch(integers,12);

        Integer[] copyArr = Arrays.copyOf(integers,integers.length-1);

        Integer[] num = new Integer[]{10,233,44,11};
        Arrays.fill(num,99);

        List<Integer> integerList = Arrays.asList(2,3,4,5,12,2);




    }

    public static void bubble(Integer[] arr, Comparator t) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; i < arr.length - 1; j++) {
                if (t.compare(arr[i], arr[j + 1]) > 0) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }
}

