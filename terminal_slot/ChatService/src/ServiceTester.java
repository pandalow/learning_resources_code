import java.io.IOException;
import chatService.*;
//The main method of the server that executes the startup server
public class ServiceTester {
    public static void main(String[] args) throws IOException{
            new Server().service();
    }
}
