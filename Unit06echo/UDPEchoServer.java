package echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {


    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket (54321);
        byte[] buffer = new byte [1024];
        DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
        socket.receive (incoming);
        String message = new String (incoming.getData(), 0, incoming.getLength ());
        DatagramPacket outgoing = new DatagramPacket(message.getBytes(), message.length(), incoming.getAddress(), incoming.getPort());
        socket.send(outgoing);
    }
}
