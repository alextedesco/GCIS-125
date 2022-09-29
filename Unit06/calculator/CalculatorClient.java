package calculator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class CalculatorClient {


    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        String string = s.nextLine();
        while (string != "exit") {
        DatagramSocket socket = new DatagramSocket ();
        DatagramPacket outgoing = new DatagramPacket (string.getBytes (), string.length (), InetAddress.getByName("localhost"), 12400);
        socket.send(outgoing);
        byte[] buffer = new byte [1024];
        DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
        socket.receive(incoming);
        String result = new String (incoming.getData(), 0, incoming.getLength ());
        System.out.print(result);
        socket.close();
        String newString = s.nextLine();
        if (newString == "exit") {
            string = newString;
        } else {
            string = result + newString;
            }
        }
        s.close();
    }
}
