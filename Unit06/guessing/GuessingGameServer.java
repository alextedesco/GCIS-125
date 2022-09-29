package guessing;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import duplexer.Duplexer;

public class GuessingGameServer extends Duplexer {

    Socket socket;
    GuessingGame game;
    GamePlayer player;
    
    public GuessingGameServer(Socket socket) throws IOException {
        super(socket);
        this.socket = socket;
        GuessingGame game = new GuessingGameImpl();
    }

    public void run () {
        player.playTheGame();
        if (socket.)
        //     game.restart();
        // } else if (quit) {
        //     game.quit();
        // } else if (guess) {
        //     game.guess(number);
        // } else {
        //     System.out.println("bad request");
        // }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket();
        Socket client = server.accept();
        GuessingGameServer gameServer = new GuessingGameServer(client);
        gameServer.run();
    }
}
