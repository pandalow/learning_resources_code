package basic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Homework01{
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("basic.PrivateTest");
        Class<PrivateTest> privateTestClass = PrivateTest.class;

        Field name = aClass.getDeclaredField("name");


        Object o = aClass.newInstance();
        name.setAccessible(true);
        name.set(o,"Cinderalee");

        Method getName = aClass.getDeclaredMethod("getName");
        System.out.println(getName.invoke(o));

    }

}
class PrivateTest {
    private String name = "helloKitty";

    public PrivateTest() {
    }

    public String getName() {
        return name;
    }
}
