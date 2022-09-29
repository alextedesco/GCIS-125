package problem02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class SumClient {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket(InetAddress.getLocalHost(), 54123);

        OutputStream output = client.getOutputStream();
        InputStream input = client.getInputStream();
        
        Scanner s1 = new Scanner(System.in);
        System.out.print("Enter An Integer: ");
        int num = s1.nextInt();

        PrintWriter writer = new PrintWriter(output);

        writer.println(num);
        writer.flush();

        Scanner s2 = new Scanner(input);

        int result = s2.nextInt();
        System.out.println("Current total sum is: " + result);
        s1.close();
        s2.close();
        System.out.println("Goodbye!");
    }
    
    
}
