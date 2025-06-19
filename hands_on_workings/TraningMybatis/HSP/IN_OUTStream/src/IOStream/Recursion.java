package IOStream;

import org.junit.Test;

public class Recursion {

    public static void main(String[] args) {
        recur(1);
    }
    public static void recur(int count){

        if(count == 10) return;
        recur(count);

        System.out.println(count);

    }
}
