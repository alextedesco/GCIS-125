package activities;

public class TheCount implements Runnable {

    static int[] COUNT = new int[1];
    int id;

    public TheCount (int id) {
        this.id = id;
    }

    @Override
    public void run() {
    synchronized(this) {
        for (int i = 0; i<100000;i++) {
            COUNT[0] = COUNT [0] + 1;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TheCount counter1 = new TheCount(1);
        Thread thread1 = new Thread(counter1);
        thread1.start();
        Thread.sleep(1000);

        System.out.println(1 + " " + COUNT[0]);

        for (int i = 2; i <= 10; i++) {
            TheCount counter = new TheCount(COUNT[0]);
            Thread thread = new Thread(counter);
            thread.start();
            Thread.sleep(1000);

            System.out.println(i + " " + COUNT[0]);
        }
    }
}
