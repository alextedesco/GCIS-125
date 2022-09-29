package guessing;

import java.io.IOException;
import java.net.Socket;

import duplexer.Duplexer;

public class GuessingGameProxy extends Duplexer implements GuessingGame {

    public GuessingGameProxy(Socket socket) throws IOException {
        super(socket);
    }

    @Override
    public void restart() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public GuessResult guess(int number) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void quit() {
        // TODO Auto-generated method stub
        
    }
    
}
