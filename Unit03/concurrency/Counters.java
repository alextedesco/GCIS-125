package concurrency;

public class Counters {

    public static void main(String[] args) throws InterruptedException {

        // RunnableCounter counter1 = new RunnableCounter(n);
        // Thread thread1 = new Thread (counter1);
        // RunnableCounter counter2 = new RunnableCounter(n);
        // Thread thread2 = new Thread (counter2);
        // RunnableCounter counter3 = new RunnableCounter(n);
        // Thread thread3 = new Thread (counter3);
        // thread1.start();
        // thread2.start();
        // thread3.start();

        CounterThread counter1 = new CounterThread(1);
        Thread thread1 = new Thread(counter1);
        CounterThread counter2 = new CounterThread(1);
        Thread thread2 = new Thread(counter2);
        CounterThread counter3 = new CounterThread(1);
        Thread thread3 = new Thread(counter3);
        CounterThread counter4 = new CounterThread(1);
        Thread thread4 = new Thread(counter4);
        CounterThread counter5 = new CounterThread(1);
        Thread thread5 = new Thread(counter5);

        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
        thread4.start();
        thread4.join();
        thread5.start();
        thread5.join();
    }  
}
