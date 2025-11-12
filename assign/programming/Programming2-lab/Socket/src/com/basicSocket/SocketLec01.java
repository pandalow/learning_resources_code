package com.basicSocket;
import java.io.*;
import java.net.*;
import java.util.*;

public class SocketLec01 {
    public static void main(String[] args) throws UnknownHostException, IOException {

        Socket socket = new Socket("universityofgalway.ie",80);//80 is for website;
        //IO Streaming
        InputStream input  = socket.getInputStream();
        OutputStream output = socket.getOutputStream();

        //Formating
        Scanner scan = new Scanner(input);
        PrintWriter out = new PrintWriter(output);

        String command = "GET / HTTP/1.0\n";

        out.println(command);
        out.flush();

        while(scan.hasNextLine()){
            String receive = scan.nextLine();
            System.out.println(receive);
        }
        scan.close();
        input.close();
        socket.close();
    }
}
