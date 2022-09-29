import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TinyWebServer {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        Socket client = server.accept();

        InputStream fromClient = client.getInputStream();
        OutputStream toClient = client.getOutputStream();

        Scanner s = new Scanner(fromClient);
        System.out.println(s.nextLine());
        System.out.println(s.nextLine());
        System.out.println(s.nextLine());

        PrintStream writer = new PrintStream(toClient);
        writer.println("HTTP/1.1 200 OK\r\n" + "Content-Length: 12\r\n" + "Content-Type: text/plain; charset=utf-8\r\n\r\n" + "Hello World!\r\n");
        writer.flush();
    }
}
