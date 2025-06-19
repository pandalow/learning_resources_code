package IOStream;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

public class PropertiesTrainning {
    @Test
    public void storeProperty() throws IOException {

        Properties properties = new Properties();
        properties.setProperty("User","0212");
        properties.setProperty("Name","zhuang");
        properties.setProperty("User","222");
        properties.store(new FileWriter("./MySql2.properties"),"This time");

        properties.load(new BufferedReader(new FileReader("./MySql2.properties")));
        properties.list(new PrintWriter(System.out));


    }
}
