package ThreadCon;

public class ThExercise01 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("hi");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 5) {
                Thread thread = new Thread(new TreadingTrain());
                thread.start();
                thread.join();
            }

        }
    }
}

class TreadingTrain implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}