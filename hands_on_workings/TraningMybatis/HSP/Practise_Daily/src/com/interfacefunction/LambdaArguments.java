package com.interfacefunction;

public class LambdaArguments {
    public static void main(String[] args) {

        runTest(s -> s.length() < 10, "galway");
        runTest(s -> s.contains("z"),"galway");

    }
    public static void runTest(Testable t, String s) {
        System.out.println(t.test(s));
    }
}
interface Testable {
    boolean test(String s);
}