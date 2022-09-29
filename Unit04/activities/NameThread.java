package activities;

public class NameThread implements Runnable {

    String name;
    int index;

    public NameThread (String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public void run() {
        // try {
        //     Thread.sleep(index * 2);
        // } catch (InterruptedException e) {
        //     System.err.println("Error!");
        // }
        System.out.print(name.charAt(index));    
    }

    public static void main(String[] args) throws InterruptedException {
        NameThread nameThread1 = new NameThread("Alex", 0);
        Thread thread1 = new Thread(nameThread1);
        NameThread nameThread2 = new NameThread("Alex", 1);
        Thread thread2 = new Thread(nameThread2);
        NameThread nameThread3 = new NameThread("Alex", 2);
        Thread thread3 = new Thread(nameThread3);
        NameThread nameThread4 = new NameThread("Alex", 3);
        Thread thread4 = new Thread(nameThread4);
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
        thread4.start();
        thread4.join();
        System.out.print("!");
    }



}