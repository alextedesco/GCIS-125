package activities;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class SearchPrinter {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.google.com");
        URLConnection connection = url.openConnection();
        connection.connect();

        InputStream inputStream = connection.getInputStream();

        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }  
}
