package basic;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class TestReflect {
    long startTime;
    long endTime;
    @Test
    public void testReflect() throws Exception{
        startTime = System.currentTimeMillis();
        Cat cat = new Cat();
        for (int i = 0; i < 10000; i++) {
            cat.hi();
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);




    }
    @Test
    public void testTwo() throws Exception{
        startTime = System.currentTimeMillis();
        Class aClass = Class.forName("basic.Cat");
        Object o = aClass.newInstance();
        Method hi = aClass.getMethod("cry");
        for (int i = 0; i < 10000; i++) {
            hi.invoke(o);
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

}
