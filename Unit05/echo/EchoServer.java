package echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(54321);
        Socket client = server.accept();

        InputStream fromClient = client.getInputStream();
        OutputStream toClient = client.getOutputStream();

        Scanner s = new Scanner(fromClient);
        PrintWriter writer = new PrintWriter(toClient);

        String string = s.nextLine();
        System.out.println(string);

        writer.write(string);
        writer.flush();
    }   
}
