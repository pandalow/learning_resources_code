package basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class reflectionEx {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("./src/re.properties"));
        String fullpath = properties.get("classfullpath").toString();
        String method = properties.get("method").toString();


        Class cls = Class.forName(fullpath);
        Object o1 = cls.newInstance();
        Method method1 = cls.getMethod(method);
        method1.invoke(o1);


    }
}
