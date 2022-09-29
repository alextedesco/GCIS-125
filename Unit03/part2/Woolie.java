package part2;

public class Woolie implements Runnable {

    String name;
    int seconds;
    String city;
    boolean cross;

    public Woolie (String name, int seconds, String city, boolean cross) {
        this.name = name;
        this.seconds = seconds;
        this.city = city;
        this.cross = cross;
    }

    public void setCross(boolean cross) {
        this.cross = cross;
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
        Woolie woolie1 = new Woolie("Woolie1", 5, "City 1", true);
        Woolie woolie2 = new Woolie("Woolie2", 5, "City 2", false); // Woolie doesn't wish to cross
        Woolie woolie3 = new Woolie("Woolie3", 5, "City 3", true);
        Woolie woolie4 = new Woolie("Woolie4", 5, "City 4", true);

        Bridge bridge = new Bridge(woolie1);
        bridge.enterBridge();
        bridge.setWoolie(woolie2);
        bridge.enterBridge(); // Doesn't execute since cross is false
        bridge.setWoolie(woolie3);
        bridge.enterBridge();
        bridge.setWoolie(woolie4);
        bridge.enterBridge();
    }
}
