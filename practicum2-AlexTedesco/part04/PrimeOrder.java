package part04;

import java.util.ArrayList;
import java.util.List;

import part02.Prime;

public class PrimeOrder implements Runnable {

    int index;
    List<Integer> list;
    Object lock = new Object();

    public PrimeOrder (int index, List<Integer> list) {
        this.index = index;
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (lock) {
            lock.notifyAll();
            try {
                list.add(Prime.NUMBERS[index]);
                lock.wait();
            } catch (InterruptedException e) {
                System.err.println("Error!");
                }
            }
        }

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < 100) {
            PrimeOrder order = new PrimeOrder(i, list);
            Thread thread = new Thread(order);
            thread.start();
            Thread.sleep(10);
            i++;
        }
        System.out.println(list); 
    }
}
