package Exercise2;

public class TestInterrupt {
    public static void main(String[] args) {
        Thread thread = new Thread(new TestThreading());
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("Big");
        }

        thread.interrupt();
        System.out.println(Thread.currentThread().getName() + "interrupt");
    }


}

class TestThreading implements Runnable {
    private boolean key = true;

    public void setKey(boolean key) {
        this.key = key;
    }

    @Override
    public void run() {
        while (key) {
            System.out.println("Hello world");
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
                System.out.println("love");
            }
        }

    }
}