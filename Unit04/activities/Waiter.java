package activities;

public class Waiter implements Runnable {

    Object lock;

    public Waiter (Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                lock.notifyAll();
                lock.wait();
            } catch (InterruptedException e) {
                System.err.println("Error!");
            }
            System.out.println("Message");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Waiter waiter = new Waiter("");
            Thread thread = new Thread(waiter);
            thread.start();
        }
    }
}
