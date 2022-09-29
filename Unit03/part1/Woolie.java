package part1;

public class Woolie implements Runnable {

    String name;
    int seconds;
    String city;

    public Woolie (String name, int seconds, String city) {
        this.name = name;
        this.seconds = seconds;
        this.city = city;
    }

    @Override
    public void run() {
        System.out.println(name + " has arrived at the bridge.");
        for (int i = 0; i <= seconds; i++) {
            if (i == 0) {
                System.out.println(name + " is starting to cross.");
            } else if (i != 0 || i != seconds) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i != seconds) {
                System.out.println("\t" + name + " " + i + " seconds");
                } else if (i == seconds) {
                    System.out.println("\t" + name + " " + i + " seconds");
                    System.err.println(name + " arrives at " + city);
                    }
                }
            }   
        }
    
    public static void main(String[] args) throws InterruptedException {
        Woolie woolie1 = new Woolie("Woolie1", 10, "City 1");
        Thread thread1 = new Thread(woolie1);
        Woolie woolie2 = new Woolie("Woolie2", 10, "City 2");
        Thread thread2 = new Thread(woolie2);
        Woolie woolie3 = new Woolie("Woolie3", 10, "City 3");
        Thread thread3 = new Thread(woolie3);
        Woolie woolie4 = new Woolie("Woolie4", 10, "City 4");
        Thread thread4 = new Thread(woolie4);
        thread1.start();
        // thread1.join();
        thread2.start();
        // thread2.join();
        thread3.start();
        // thread3.join();
        thread4.start();
        // thread4.join();
    }
}
