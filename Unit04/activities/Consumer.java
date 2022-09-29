package activities;

import java.util.List;

public class Consumer implements Runnable {

    private final int id;
    private List<String> queue;

    public Consumer(int id, List<String> queue) {
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            String message = null;
            synchronized(queue) {
                while(queue.isEmpty()) {
                    try {
                        System.out.println("Consumer " + id + ": NO WORK AVAILABLE");
                        queue.wait();
                    } catch (InterruptedException e) {}
                }
                message = queue.remove(0);
            }
            System.out.println("Consumer " + id + ": " + message);
        }
    }
}