package concurrency;

public class RunnableCounter implements Runnable {

    private final int id;
    private String name = "Name: ";
    
    public RunnableCounter (int id) {
        this.id = id;
    }
    public void run () {
        for (int i = id; i <= 100; i++) { 
        System.out.println (name + i);
        }
    }
    
    public static void main (String[] args) {
        Runnable example = new RunnableCounter (1);
        Thread exampleThread = new Thread (example);
        exampleThread.start ();
        }
    }
    