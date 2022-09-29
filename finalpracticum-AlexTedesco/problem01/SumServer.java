package problem01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SumServer {


    public static void main(String[] args) throws IOException {
        int i = 0;


        while (true) {
        System.out.println("Waiting for client..."); 
        ServerSocket server = new ServerSocket(54123);
        Socket client = server.accept();
        System.out.println("client Connected!");
        InputStream fromClient = client.getInputStream();
        OutputStream toClient = client.getOutputStream();

        Scanner s = new Scanner(fromClient);
        int request = s.nextInt();
        System.out.println("Received " + request);

        i = i + request;

        System.out.println("Sum is now: " + i);

        PrintWriter writer = new PrintWriter(toClient);
        writer.println(i);
        writer.flush();
        System.out.println("Sending: " + i);
        server.close();
        s.close();
        System.out.println("client Closed.");
        }        
    }
}
