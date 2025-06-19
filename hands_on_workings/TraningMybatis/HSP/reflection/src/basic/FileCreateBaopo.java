package basic;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;


public class FileCreateBaopo {
    public static void main(String[] args) throws Exception {

        Class<?> fileCls= Class.forName("java.io.File");

        Constructor<?>[] constructors = fileCls.getDeclaredConstructors();
        for(Constructor c : constructors){
            System.out.println(c);
        }
        Constructor<?> dconstruct = fileCls.getDeclaredConstructor(String.class);
        Object o = dconstruct.newInstance("./woola.dat");
        Method createNewFile = fileCls.getDeclaredMethod("createNewFile");
        createNewFile.invoke(o);

    }
}
