package tinychat;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TinyChatClient {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket(InetAddress.getLocalHost(), 12410);

        OutputStream output = client.getOutputStream();
        InputStream input = client.getInputStream();

        Scanner s1 = new Scanner(System.in);
        System.out.print("Enter your name to connect to tinychat: ");
        String name = s1.nextLine();

        PrintWriter writer = new PrintWriter(output);
        writer.write(name);
        writer.flush();

        Scanner s2 = new Scanner(input);
        String connected = s2.nextLine();
        System.out.println(connected);

        PrintWriter writer2 = new PrintWriter(output);
        String message = s1.nextLine();
        writer2.write(message);
        writer.flush();

        s1.close();
    }
    
}
