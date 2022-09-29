package echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    public static void main(String[] args) throws IOException {
        InetAddress host = InetAddress.getLocalHost();
        Socket client = new Socket(host, 54321);

        OutputStream toServer = client.getOutputStream();
        InputStream fromServer = client.getInputStream();

        PrintWriter writer = new PrintWriter(toServer);
        writer.println("Message");
        writer.flush();
        System.out.println("Line");
        Scanner s = new Scanner(fromServer);

        String string = s.nextLine();
        System.out.println(string);
    }
}
