package Exercise;

import java.util.Arrays;

public class A03 {
    public static void main(String[] args) {
        int[] aa = {1,2,3,4,5};
        int[] bb = copyArr(aa);
        Arrays.stream(aa).sorted().forEach(System.out::println);

        System.out.println();

        Arrays.stream(bb).forEach(System.out::println);
    }
    public static int[] copyArr(int[] array){
        int[] copyAarray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copyAarray[i] = array[i];
        }
        return copyAarray;
    }
}
