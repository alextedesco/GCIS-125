package problem03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPSumServer {

    public static void main(String[] args) throws IOException {
        int i = 0;
        while (true) {
        System.out.println("Waiting for client...");
        DatagramSocket socket = new DatagramSocket (54125);
        byte[] buffer = new byte [1024];
        DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
        socket.receive (incoming);
        System.out.println("Client Connected!");
        String message = new String (incoming.getData(), 0, incoming.getLength ());
        int num = Integer.parseInt(message);
        System.out.println("Received: " + num);
        i = i + num;
        System.out.println("Sum is now: " + i);
        String string = String.valueOf(i);
        DatagramPacket outgoing = new DatagramPacket(string.getBytes(), string.length(), incoming.getAddress(), incoming.getPort());
        socket.send(outgoing);
        System.out.println("Sending: " + i);
        socket.close();
        System.out.println("Client Closed.");
        }
    }
}