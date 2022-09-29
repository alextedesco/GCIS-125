package activities;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class NetworkTime {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket( "time.nist.gov", 13);
        InputStream input = socket.getInputStream ();
        Scanner scanner = new Scanner (input);
        while (scanner.hasNext() == true) {
        String message = scanner.next ();
        System.out.print (message + " ");
        }   
        scanner.close();
        socket.close();
        System.out.println ();
    }
}
