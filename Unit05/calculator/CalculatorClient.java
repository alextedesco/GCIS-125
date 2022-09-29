package calculator;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket(InetAddress.getLocalHost(), 12400);

        OutputStream output = client.getOutputStream();
        InputStream input = client.getInputStream();
        
        Scanner s1 = new Scanner(System.in);
        System.out.print("Enter Calculation: ");
        String string = s1.nextLine(); // 2 + 2

        PrintWriter writer = new PrintWriter(output);

        writer.println(string);
        writer.flush();

        Scanner s2 = new Scanner(input);

        String result = s2.nextLine();
        System.out.println(result);
    }
}
