package activities;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Name {


    public static void main(String[] args) throws IOException, UnknownHostException {
        Socket socket = new Socket("swec-123.rit.edu", 33075);
        PrintWriter printer = new PrintWriter(socket.getOutputStream());
        printer.println("Alex Tedesco");
        printer.flush();
        socket.close();
    }
}
