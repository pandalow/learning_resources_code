package TankGameV4;

public class Bullet implements Runnable {

    private int x;
    private int y;
    private int direct;
    private int speed = 5;

    boolean isLive;

    public Bullet(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        isLive = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (direct) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }
            if (!(x > 0 && x <= 1000 && y > 0 && y <= 750 && isLive)) {
                isLive = false;
                System.out.println("bullet end");
                break;
            }
        }
    }
}

