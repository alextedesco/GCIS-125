package echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoClient {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket ();
        String string = "Message";
        DatagramPacket outgoing = new DatagramPacket (string.getBytes (), string.length (),
        InetAddress.getByName("localhost"), 54321);
        socket.send(outgoing);
        byte[] buffer = new byte [1024];
        DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
        socket.receive(incoming);
        System.out.println(incoming.toString());
        socket.close();
    }
}
