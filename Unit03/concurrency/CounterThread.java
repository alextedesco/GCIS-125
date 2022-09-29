package concurrency;

public class CounterThread extends Thread {
    private final int id;
    private String name = "Name: ";

    public CounterThread (int id) {
    this.id = id;
    }
    
    @Override
    public void run () {
        for (int i = id; i <= 10; i++)
        System.out.println (name + i);
    }

    public static void main (String[] args) {
        Thread example = new CounterThread (1);
        example.start ();
        while (example.isAlive()) {
        }
        for (char c = 'a'; c < 'z'; c++) {
            System.out.println(c);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.err.println("Interrupted!");
            }
        }
    }
}