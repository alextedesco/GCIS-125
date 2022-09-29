package part02;

public class PrimePrinter implements Runnable {

    int index;

    public PrimePrinter (int index) {
        this.index = index;
    }

    @Override
    public void run() {
        System.out.println(Prime.NUMBERS[index]);
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            PrimePrinter printer = new PrimePrinter(i);
            Thread thread = new Thread(printer);
            thread.start();
            Thread.sleep(50);
        }
        System.out.println("Done!");
    }
}
