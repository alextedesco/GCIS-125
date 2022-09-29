package activities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Producer implements Runnable {

    private static final Random RNG = new Random();

    private final int id;
    private final List<String> queue;

    public Producer(int id, List<String> queue) {
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {
        int numberOfMessages = 1;
        while(true) {
            // sleep for 1000 ms
            try {
                Thread.sleep(RNG.nextInt(2000) + 1000);
            } catch (InterruptedException e) {}
            // generate 1-5 messages
            int num = RNG.nextInt(5) + 1;
            // add them to the queue
            for(int i=0; i<num; i++) {
                String message = "Producer " + id + ": message #" + 
                    numberOfMessages++;
                synchronized(queue) {
                    queue.add(message);
                    // notify any waiting threads
                    queue.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> queue = new ArrayList<>();
        for(int i=1; i<6; i++) {
            Consumer consumer = new Consumer(i, queue);
            Thread thread = new Thread(consumer);
            thread.start();
        }

        for(int i=1; i<3; i++) {
            Producer producer = new Producer(i, queue);
            Thread thread = new Thread(producer);
            thread.start();
        }
    }
    
}