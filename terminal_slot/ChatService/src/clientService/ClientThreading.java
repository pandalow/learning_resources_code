package clientService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;
/*
    This class creates a new thread to listen for client messages.
    Saves a socket for connecting to the client
 */
class ClientThreading implements Runnable {
    private Socket socket;

    public ClientThreading(Socket socket) {
        this.socket = socket;
    }
    //threading method, Keeps the client listening for messages
    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String message;
            while ((message = br.readLine()) != null) { // persistent reading
                System.out.println(message);
            }
        } catch (IOException e) {
            if (e instanceof SocketException) {
                System.out.println("Client disconnected.");
            } else {
                e.printStackTrace();
            }
        } finally {
            // Try to close the socket anyway
            if (socket != null && !socket.isClosed()) {
                try {
                    socket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
