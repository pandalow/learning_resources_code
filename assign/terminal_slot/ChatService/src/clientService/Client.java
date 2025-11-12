package clientService;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
/*
1. The main interface for user interaction, linked to a server-side socket,
    accepts user input and packages it for output to the server.
2. At the same time, the first time you log in, you will create a listening Threading.
3.PrintWriter is used to output the stream
 */
public class Client {

    String nickName;
    private Socket socket;

    public Client(String nickName) {
        this.nickName = nickName;
    }


    public void linkServer() throws IOException {
        // Creating a link to Service
        socket = new Socket(InetAddress.getLocalHost(), 9999);

        //Encapsulate the nickName into a message to be processed by the server;
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.println(nickName);
        pw.flush();

        //Create a new thread with user customer service listening for messages
        Thread thread = new Thread(new ClientThreading(socket));
        thread.start();
        System.out.println("Client threading is running");
        commandExplain();

        //Starts waiting for user commands and processing user inputs
        Scanner scan = new Scanner(System.in);
        while (true) {
            //Console command
            System.out.println("==========================");
            System.out.println("Please enter your command:");
            String command = scan.nextLine();
            //Using condition to catch the all input situation
            String message = null;

            if (command.equals("/quit")) {
                socket.close();
                message = command;
                pw.println(message);
                pw.flush();
                return;
            } else if (command.startsWith("/nick ")||command.startsWith("/list")||command.startsWith("/msg ")||command.startsWith("/bc ")) {
                message = command;
                pw.println(message);
                pw.flush();
            } else if (command.startsWith("/help")) {
                commandExplain();
            } else {
                System.out.println("Invalid input，Please enter again");
            }
        }
    }

    // help command, list all the notes
    public void commandExplain() {
        System.out.println("==============Command==============");
        System.out.println("/nick NickName -- change your Nick Name");
        System.out.println("/msg GetterNickName content -- send a private message to another user");
        System.out.println("/bc content -- send a broadcast message to all users");
        System.out.println("/list -- list all the users who linking to the server");
        System.out.println("/quit -- quit the client");
        System.out.println("/help -- list all the command again");
    }
}






