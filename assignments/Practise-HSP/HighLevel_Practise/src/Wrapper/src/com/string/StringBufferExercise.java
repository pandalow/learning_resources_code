package Wrapper.src.com.string;


public class StringBufferExercise {
    public static void main(String[] args) {
        int n = 1000000;
        String name = "1";

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            name += i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

        StringBuffer name1 = new StringBuffer("1");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            name1.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

        StringBuilder name2 = new StringBuilder("1");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            name2.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
