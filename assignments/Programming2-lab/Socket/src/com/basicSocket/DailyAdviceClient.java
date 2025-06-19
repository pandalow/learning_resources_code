package com.basicSocket;
import java.io.*;
import java.net.*;

public class DailyAdviceClient {
    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();

        try {
            client.go();
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void go() throws UnknownHostException,IOException{
        Socket socket  = new Socket("localhost",7777);
        System.out.println("Client connected to server");

        InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader reader = new BufferedReader(streamReader);

        String advice = reader.readLine();

        System.out.println(advice);

        reader.close();
        socket.close();

    }
}
