package ThreadCon;

public class YieldTest {

    public static void main(String[] args) {
        Thread thread = new Thread(new SecondThreading());
        thread.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("hi");
            if (i == 5) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    static class SecondThreading implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("hello");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
