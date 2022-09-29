package calculator;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        ServerSocket server = new ServerSocket(12400);
        Socket client = server.accept();
        System.out.println("Connected");

        InputStream fromClient = client.getInputStream();
        OutputStream toClient = client.getOutputStream();

        Scanner s = new Scanner(fromClient);
        String request = s.nextLine();

        String[] tokens = request.strip().split(" ");

        String result;
        float operand1 = Float.parseFloat(tokens[0]);
        float operand2 = Float.parseFloat(tokens[2]);
        result = "" + calculator.calculate(tokens[1], operand1, operand2);

        PrintWriter writer = new PrintWriter(toClient);
        writer.println(result);
        writer.flush();
    }
}
