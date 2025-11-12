package Wrapper.src.com.exerciseColleciton;

public class Homework02 {
    public static void main(String[] args) {
        Customer c = new Customer();
        Thread thread01 = new Thread(c);
        Thread thread02 = new Thread(c);
        thread01.start();
        thread02.start();
    }
}

class Customer implements Runnable {
    static int money = 10000;
    private boolean key = true;

    @Override
    public void run() {
        while (key) {
            synchronized (this) {
                try {
                    if (money == 0) {
                        key = false;
                        return;
                    }
                    money -= 1000;
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Money left: " + money);
            }
        }
    }
}