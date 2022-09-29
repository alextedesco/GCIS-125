package part03;

import java.util.ArrayList;
import java.util.List;

public class RandomList implements Runnable {

    int id;
    List<Integer> list;

    public RandomList (int id, List<Integer> list) {
        this.id = id;
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            if (list.contains(id)) {
                System.out.println(id + ": finished!");
            } else {
                System.out.println(id + ": beginning to add values...");
                list.add(id);
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        List<Integer> intList = new ArrayList<>();

        int id = 1;
        while (id <= RandomHelper.SIZE) {
            RandomList list = new RandomList(id, intList);
            Thread thread = new Thread(list);
            thread.start();
            thread.join();
            id++;
        }
        id = 1;
        while (id <= RandomHelper.SIZE) {
            RandomList list = new RandomList(id, intList);
            Thread thread = new Thread(list);
            thread.start();
            thread.join();
            id++;
        }
        RandomHelper.assertList(intList);
        System.out.println("The list is correct!");  
    }
}
