package chatService;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*  Login service
    Mainly used to accept logins from clients and create a thread
 */
public class Server{
    private ServerSocket serverSocket;


    /*  1. Accept client login, serverSocket IP address is localhost, port is 9999.
        2. When a new client login is received, it receives the deposited nickName and opens a listening thread.
        3. Eventually the socket and nickName of the corresponding thread are stored in a hashMap Management
     */
    public void service() throws IOException {

        serverSocket = new ServerSocket(9999);
        System.out.println("Starting Server>>>>>");

        while (true) {
            try {
                Socket socket = serverSocket.accept();

                //This place handles the login user information and wraps the nickname out of it.
                InputStreamReader isr = new InputStreamReader(socket.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                String nickName = br.readLine();
                System.out.println("System acquire the username: " + nickName);

                //Create a new listener thread;
                ServerThreading server = new ServerThreading(socket,nickName);
                Thread thread = new Thread(server);
                thread.start();
                System.out.println("System creating Threading for: " + nickName);

                // Insert hashtable to load users and server threads into the hashtable
                ServerThreadingManagement.addMap(nickName, server);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
