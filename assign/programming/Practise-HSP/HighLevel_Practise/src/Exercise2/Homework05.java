package Exercise2;

public class Homework05 {
    public static void main(String[] args) {
        new A().test();
    }
}

class A {

    private final String name = "AA";

    public void test() {

        class B {
            private final String name = "BB";

            public void show() {
                System.out.println(name);
                System.out.println(A.this.name);
            }
        }
        new B().show();
    }
}