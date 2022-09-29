package duplexer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Duplexer {

    Socket socket;
    Scanner s;
    PrintWriter writer;

    public Duplexer (Socket socket) throws IOException {
        this.socket = socket;
        Scanner s = new Scanner(socket.getInputStream());
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
    }

    public void send (String string) {
        writer.println(string);
        writer.flush();
    }

    public String data() {
        return s.nextLine();
    }

    public void close() throws IOException {
        socket.close();
    }
}
