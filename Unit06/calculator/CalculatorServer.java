package calculator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;

public class CalculatorServer {

    public static void main(String[] args) throws IOException {
        List<BinaryOperation> OPERATIONS = new ArrayList<>(7);
        OPERATIONS.add (new Addition());
        OPERATIONS.add (new Subtraction());
        OPERATIONS.add (new Multiplication());
        OPERATIONS.add (new Division());
        OPERATIONS.add (new FloorDivision());
        OPERATIONS.add (new Exponent());
        Calculator calculator = new Calculator(OPERATIONS);


        DatagramSocket socket = new DatagramSocket (12400);
        byte[] buffer = new byte [1024];
        while (true) {
        DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
        socket.receive (incoming);
        String message = new String (incoming.getData(), 0, incoming.getLength ());
        String[] tokens = message.strip().split(" ");
        String result;
        float operand1 = Float.parseFloat(tokens[0]);
        float operand2 = Float.parseFloat(tokens[2]);
        result = "" + calculator.calculate(tokens[1], operand1, operand2);
        DatagramPacket outgoing = new DatagramPacket(result.getBytes(), result.length(), incoming.getAddress(), incoming.getPort());
        socket.send(outgoing);
        }
    }    
}
