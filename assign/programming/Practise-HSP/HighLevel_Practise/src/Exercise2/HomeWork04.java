package Exercise2;

public class HomeWork04 {
    public static void main(String[] args) {
        new Cellphone().testWork(new Calculate() {
            @Override
            public void work() {
                System.out.println("hellow World");
            }
        });
    }
}

interface Calculate{
    void work();
}
class Cellphone{
    void testWork(Calculate calculate){
        calculate.work();
    }
}