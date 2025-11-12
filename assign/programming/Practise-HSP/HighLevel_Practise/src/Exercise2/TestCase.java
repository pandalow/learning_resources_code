package Exercise2;

public class TestCase {
    public static void main(String[] args) {
        Thread a = MultiThread.getA();
        a.start();
        Thread b = MultiThread2.getA();
        b.start();
    }
}

class MultiThread implements Runnable {
    private static Thread a = new Thread(new MultiThread());

    private MultiThread() {
    }

    public static Thread getA() {
        return a;
    }

    @Override
    public void run() {
        try {
            int i = 1;
            while (i <= 10) {
                System.out.println("hello world");
                Thread.sleep(1000);
                i++;
            }
        } catch (Exception e) {
            System.out.println("Threading ex");
        }
    }
}
class MultiThread2 implements Runnable {
    private static Thread b = new Thread(new MultiThread2());

    private MultiThread2() {
    }

    public static Thread getA() {
        return b;
    }

    @Override
    public void run() {
        try {
            int i = 1;
            while (i <= 5) {
                System.out.println("hi");
                Thread.sleep(500);
                i++;
            }
        } catch (Exception e) {
            System.out.println("Threading ex");
        }
    }
}

