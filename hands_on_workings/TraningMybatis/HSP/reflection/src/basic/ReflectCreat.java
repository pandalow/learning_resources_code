package basic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectCreat {
    public static void main(String[] args) throws Exception {

        Class<?> aClass = Class.forName("basic.User");
        //直接调用无参构造器
        Object o = aClass.newInstance();
        System.out.println(o);
        //传入xxx.class来获得有参构造器
        Constructor<?> constructor = aClass.getConstructor(String.class);
        Object o1 = constructor.newInstance("hsp");
        System.out.println(o1);
        //获得私有构造器,暴破建立对象
        Constructor<?> constructor1 = aClass.getDeclaredConstructor(int.class, String.class);
        constructor1.setAccessible(true);
        Object o2 = constructor1.newInstance(10, "hello");
        System.out.println(o2);

        // ________________

        Class<?> aClass1 = Class.forName("basic.Student");
        Object o3 = aClass1.newInstance();
        Field age = aClass1.getField("age");
        age.set(o3,2);
        System.out.println(o3);

        Field name = aClass1.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o3,"212");
        name.set(null,"cool");
        System.out.println(o3);

        //------------------------------
        Class<?> aClass2 = Class.forName("basic.Boss");
        Method hi = aClass2.getMethod("hi", String.class);
        Object o4 = aClass2.newInstance();
        hi.invoke(o4,"love");

        Method say = aClass2.getDeclaredMethod("say", int.class, String.class, char.class);
        say.setAccessible(true);
        System.out.println(say.invoke(null,1,"love",'s'));

        Object invoke = say.invoke(null, 2, "coll", 't');



    }
}

