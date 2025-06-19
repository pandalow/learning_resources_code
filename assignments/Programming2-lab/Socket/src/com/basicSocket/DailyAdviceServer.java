package com.basicSocket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {
    private String[] adviceList = {
            "Eat better,sleep better",
            "Keep hydrated",
            "Be honest"};
    public static void main(String[] args) {

        DailyAdviceServer server = new DailyAdviceServer();
        try {
            server.go();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAdviceList(int i){
        return adviceList[i];
    }
    public void go() throws IOException {
        ServerSocket serverSock = new ServerSocket(7777);
        while(true){

            Socket s = serverSock.accept();
            System.out.println("Connection accepted from client");

            PrintWriter writer = new PrintWriter(s.getOutputStream());
            String advice = getAdviceList(0);
            writer.println(advice);
            writer.close();
            s.close();
        }
    }
}
