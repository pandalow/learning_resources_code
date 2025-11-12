package TankGameV5;

public class Bomb {
    int x,y;
    int life = 8;
    boolean isLive = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void lifeDown(){
        if(life > 0){
            life--;
        }else{
            isLive = false;
        }
    }
}
