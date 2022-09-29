package concurrency;

public class Countdown implements Runnable {

    private final int id;
    private String tMinus = "T-";
    
    public Countdown (int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = id; i >= 0; i--) {
            System.out.println(tMinus + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Interrupted!");
            }
        } 
    }
    public static void main(String[] args) {
        Runnable countdown = new Countdown (10);
        Thread thread = new Thread (countdown);
        thread.start ();
    }
}
