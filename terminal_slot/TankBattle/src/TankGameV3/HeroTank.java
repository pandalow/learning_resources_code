package TankGameV3;

public class HeroTank extends Tank {

    Bullet bullet = null;

    public HeroTank(int x, int y) {
        super(x, y);
    }

    public void shotBullet() {
        switch (getDirect()) {
            case 0:
                bullet = new Bullet(getX() + 20, getY(), 0);
                break;
            case 1:
                bullet = new Bullet(getX() + 60, getY() + 20, 1);
                break;
            case 2:
                bullet = new Bullet(getX() + 20, getY() + 60, 2);
                break;
            case 3:
                bullet = new Bullet(getX(), getY() + 20, 3);
                break;
        }
        Thread thread = new Thread(bullet);
        thread.start();
    }
}
