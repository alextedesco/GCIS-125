package activities;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Listener {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12347);
        Socket socket = server.accept();
        System.out.println("Connected!");
        socket.close();       
    }
}
