import java.util.ArrayList;
import java.util.Scanner;

public class SequentialCount implements Runnable {

    int num;

    public SequentialCount (int num) {
        this.num = num;
    }

    @Override
    public void run () {
        System.out.println(num);
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter Number: ");

        int num = s.nextInt();

        ArrayList<Thread> threadList = new ArrayList<>();

        for (int i = 1; i <= num; i++) {
            Thread thread = new Thread(new SequentialCount(i));
            threadList.add(thread);
        }

        for (Thread thread : threadList) {
            thread.start();
            thread.join();
        }

        s.close();

    }
}
