package Wrapper.src.com.m;

import java.math.BigInteger;

public class BigInteger01 {
    public static void main(String[] args) {
//        long l = 2378888888889999999999999999999l;
        BigInteger bigInteger = new BigInteger("2378888888889999999999999999999");
        System.out.println("l = " + bigInteger);
        BigInteger kk =  bigInteger.add(new BigInteger("212444444444")).divide(new BigInteger("4125125125"));

        System.out.println(kk);
    }
}
