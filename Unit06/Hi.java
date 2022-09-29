public class Hi extends Thread {

    @Override
    public void run() {
        System.out.println("Hi!");
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Hi();
            thread.start();
            thread.join();
        }
        System.out.println("Goodbye!");
    }
}
