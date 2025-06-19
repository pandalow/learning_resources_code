import java.io.IOException;
import java.util.Scanner;

import clientService.*;
// The main method, which is the interface entry point of the client program
public class ClientView {
    public static void main(String[] args) throws IOException {
    new ClientView().view();
    }

    public void view() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please Set your NickName: ");
        String nickName = scan.nextLine();
        new Client(nickName).linkServer();
    }
}
