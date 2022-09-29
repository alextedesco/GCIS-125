package concurrency;

import java.util.ArrayList;
import java.util.List;

public class ListAdder implements Runnable {

    private List<Integer> sharedList;
    private int num;

    public ListAdder (List<Integer> sharedList, int num) {
        this.sharedList = sharedList;
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            sharedList.add(i);
        }
        
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            ListAdder adder = new ListAdder(list, 50);
            Thread thread = new Thread(adder);
            thread.start();
            threadList.add(thread);
        }
        for (Thread thread : threadList) {
            thread.join();
        }
        System.out.println(list.size());
    }
}
