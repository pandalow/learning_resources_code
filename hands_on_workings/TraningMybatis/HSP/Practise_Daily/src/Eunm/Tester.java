package Eunm;

public class Tester {
    public static void main(String[] args) {
        EnumExercise01[] weeks = EnumExercise01.values();
        for(EnumExercise01 e :weeks){
            System.out.println(e.toString());
        }
    }
}
