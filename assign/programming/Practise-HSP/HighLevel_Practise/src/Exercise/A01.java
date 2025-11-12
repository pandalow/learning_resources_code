package Exercise;

import java.util.Arrays;

public class A01 {
    private static double[] array = new double[]{3.9,12.3,4.1,3.1};

    public static void main(String[] args) {
        max();
    }
    public static void max(){
        double large = 0.0;
        for (int i = 0; i < array.length-1; i++) {
            if(large < array[i]) large = array[i];
        }
        System.out.println(large);
    }
}
