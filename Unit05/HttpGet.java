import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class HttpGet {
    
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("www.google.com", 80);
        
        OutputStream output = socket.getOutputStream();
        InputStream input = socket.getInputStream();
        

        String request = "Get / HTTP/1.1\r\n" + "Host: www.google.com\r\n" + "Connection: close\r\n\r\n";
        byte[] bytes = request.getBytes();

        PrintStream writer = new PrintStream(output);
        writer.println(bytes);
        writer.flush();
        
        Scanner s = new Scanner(input);
        String string = s.nextLine();
        System.out.println(string);
    }
}
