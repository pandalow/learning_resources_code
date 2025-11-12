package chatService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/*
    1.This entity is used to save the Threading and IO stream of this thread, after the client link,
      a new ServerThreading thread will be created and stored into the HashMap management.
    2.The socket is used to represent the thread, and can be used to support the call lookup when
      sending group and private messages.
    3.IO streams can be placed here to prevent duplicate creation, thus avoiding waste of resources.
     */
public class ServerThreading implements Runnable {

    //privatized sockets and IO streams
    private Socket socket;
    private PrintWriter pw;
    private BufferedReader br;
    private String nickName;

    // A flexible thread management value that is shared by threads and can
    // be notified to other threads about the state of the thread.
    private volatile boolean running = true;

    //Constructor to store the created socket and create the corresponding IO stream.
    public ServerThreading(Socket socket, String nickName) throws IOException {
        this.socket = socket;
        this.nickName = nickName;
        this.pw = new PrintWriter(socket.getOutputStream(), true);
        this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public Socket getSocket() {
        return socket;
    }

    /* The main method of listening, the thread method (run) is executed.
    1. using a while (true) loop to continuously listen for messages from the client
    2. using String's spilt() method to split the client's incoming statements, separating them by spaces;
       Thereby creating an array of commands in command[], based on the input format:
           command[0] is the command (/msg, /list etc).
           In the case of private messages
           command[1] is the receiver. command[2] is the message content;
           In other cases
           command[1] is the message content
    3. The method area uses if to judge the command:
        /quit terminates the thread, sets the boolean to false, and executes the closeResourse method to verify that all resources are closed.
        /nick looks up the value of the nickName in the Hashmap and calls the update() handler method to replace the corresponding nick value.
        /bc traverses the entire HashMap structure to retrieve the online socket and send the message.
        /msg will look up the corresponding socket by nickName, send a new Output stream to send the message, and if there is no corresponding user, it will return the no user alert;
        /list will call the method of traversing the entire hashmap, so as to browse all the online clients.
     */
    public void run() {

        try {
            String message;
            while (running && (message = br.readLine()) != null) { // reading message;
                System.out.println("Receive message: " + message);

                //String message to spilt the
                String[] command = message.split(" ");

                // Deal with the condition
                if (command[0].equals("/quit")) {
                    running = false;
                    break; // Exit the loop, resources will be automatically closed in try-with-resources
                } else if (command[0].equals("/nick")) {
                    String newNickName = command[1];
                    ServerThreadingManagement.updateNickName(nickName, newNickName);
                    this.nickName = newNickName;
                    pw.println(newNickName + " is successful re-set, enjoy chat~~");
                    pw.flush();
                } else if (command[0].equals("/bc")) {
                    broadCast(command);
                } else if (command[0].equals("/msg")) {
                    privateMessage(command);
                } else if (command[0].equals("/list")) {
                    String list = ServerThreadingManagement.getOnlineUser();
                    pw.println("The online user includes: "+ list);
                    pw.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        System.out.println(nickName + " connection closes and the thread ends.");
    }
    // broadcasting a message, traversing the HashMap via Iterator, and creating a PrintWriter stream to send a new message
    public void broadCast(String[] command) throws IOException {
        String content = command[1];
        ConcurrentHashMap<String, ServerThreading> map = ServerThreadingManagement.getMap();
        Iterator<String> itr = map.keySet().iterator();
        while (itr.hasNext()) {
            String getterName = itr.next().toString();
            PrintWriter stream = new PrintWriter(map.get(getterName).getSocket().getOutputStream());
            stream.println("<"+ this.nickName +">" + " has sent a message to all: " + content);
            stream.flush();
        }
    }
    //private message sending, find out if the corresponding getterName exists and
    // call the corresponding socket to send the message
    public void privateMessage(String[] command) throws IOException {
        String content = command[2]; //Get the actual contents of the command
        String getterName = command[1]; // Command[1] is the nickname of the receiver
        ConcurrentHashMap<String, ServerThreading> map = ServerThreadingManagement.getMap();

        if (map.containsKey(getterName)) { // Check if the target user exists
            PrintWriter stream = new PrintWriter(map.get(getterName).getSocket().getOutputStream());
            stream.println("<"+ this.nickName +">" + " has sent you a message: " + content);
            stream.flush();
        } else {
            pw.println("Cannot not found user");
            pw.flush();
        }
    }
    //Explicitly disable all resources
    private void closeResources() {
        try {
            if (br != null) br.close(); // Explicitly disable BufferedReader
            if (pw != null) pw.close(); // PrintWriter does not need to be explicitly closed because it is automatically closed when the socket is closed.
            if (socket != null && !socket.isClosed()) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}







