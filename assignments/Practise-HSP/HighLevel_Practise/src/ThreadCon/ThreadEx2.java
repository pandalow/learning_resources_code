package ThreadCon;

import java.util.Scanner;

public class ThreadEx2 {
    public static void main(String[] args) {

        Thread thread = new Thread(new ReadQ());
        thread.start();
        ReadQ.ReadQ();
        while(true){
            System.out.println(Math.random() *1000);
        }


    }
}
class ReadQ implements Runnable{

    public static synchronized void ReadQ(){
        boolean key = true;
        while(key) {
            Scanner scanner = new Scanner(System.in);
            char q = scanner.nextLine().charAt(0);
            if(q  == 'q') key = false;
        }
    }
    @Override
    public void run(){
        ReadQ();
    }
}