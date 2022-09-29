package activities;

public class Deadlock extends Thread {

    static Object key1 = new Object();
    static Object key2 = new Object();

    private static class Thread1 extends Thread {
        public void run() {
           synchronized (key1) {
              System.out.println("Thread 1 - Holding Key 1");
              synchronized (key2) {
                 System.out.println("Thread 1 - Holding Key 1 & 2");
              }
           }
        }
     }

     private static class Thread2 extends Thread {
        public void run() {
           synchronized (key2) {
              System.out.println("Thread 2 - Holding Key 2");
              synchronized (key1) {
                 System.out.println("Thread 2 - Holding Key 1 & 2");
              }
           }
        }
     }

    public static void main(String[] args) {
      Thread1 thread1 = new Thread1();
      Thread2 thread2 = new Thread2();
      thread1.start();
      thread2.start();
   }  
}
