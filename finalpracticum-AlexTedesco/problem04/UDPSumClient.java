package problem04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPSumClient {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter An Integer: ");
        int num = s.nextInt();
        String string = String.valueOf(num);
        DatagramSocket socket = new DatagramSocket ();
        DatagramPacket outgoing = new DatagramPacket (string.getBytes (), string.length (), InetAddress.getByName("localhost"), 54125);
        socket.send(outgoing);
        byte[] buffer = new byte [1024];
        DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
        socket.receive(incoming);
        String result = new String (incoming.getData(), 0, incoming.getLength ());
        System.out.print("Current total sum is: " + result);
        socket.close();
        s.close();
    }        
}