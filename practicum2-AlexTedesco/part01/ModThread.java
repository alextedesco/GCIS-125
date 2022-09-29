package part01;

public class ModThread implements Runnable {

    int v;

    public ModThread (int v) {
        this.v = v;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            if (i % v == 0) {
                System.out.println(v + ": " + i);
            }
        }
    }

    public static void main(String[] args) {
        ModThread modThread = new ModThread(2);
        Thread thread = new Thread(modThread);
        thread.start();
    }  
}
