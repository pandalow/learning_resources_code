package basic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class reflectionEx02 {
    public static void main(String[] args) throws Exception {
        Class catCls = Class.forName("Cat");
        Object o = catCls.newInstance();
        Field age = catCls.getField("age");
        Constructor constructor = catCls.getConstructor();
        Constructor constructor1 = catCls.getConstructor(String.class);
        age.get(o);

    }
}
