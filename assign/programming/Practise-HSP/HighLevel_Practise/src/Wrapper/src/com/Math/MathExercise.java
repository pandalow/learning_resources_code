package Wrapper.src.com.Math;

public class MathExercise {
    public static void main(String[] args) {
            int abs = Math.abs(-9);
            double pow = Math.pow(2,4);
            double ceil = Math.ceil(-3.0001);
            double floor = Math.floor(-3.001);
            long round = Math.round(5.112);
        for (int i = 0; i < 100; i++) {
            int a = 2;
            int b = 10;
            int c = (int)(a + Math.random()*(b- a+1));
            System.out.println(c);
        }

    }
}
