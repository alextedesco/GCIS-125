package tinychat;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TinyChatServer {


    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12410);
        Socket client = server.accept();
        // System.out.println("Connected");

        InputStream fromClient = client.getInputStream();
        OutputStream toClient = client.getOutputStream();

        Scanner s = new Scanner(fromClient);
        String name = s.nextLine();

        
        PrintWriter writer = new PrintWriter(toClient);
        writer.println("Connected");
        writer.flush();


        PrintWriter writer2 = new PrintWriter(toClient);
        writer2.write(name + ": Connected");

        String message = s.nextLine();
        while (message != "quit") {
            PrintWriter writer3 = new PrintWriter(toClient);
            writer3.write(name + ": " + message);
        }
        server.close();
        s.close();
    }
    
}
