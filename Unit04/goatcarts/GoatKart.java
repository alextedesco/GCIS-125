package goatcarts;

public class GoatKart implements GoatCartInterface, Runnable {

    String name;
    int kartNumber;
    int currentLap;
    int time;
    Troll troll;

    public GoatKart(String name, int kartNumber, int currentLap, int time, Troll troll) {
        this.name = name;
        this.kartNumber = kartNumber;
        this.currentLap = currentLap;
        this.time = time;
        this.troll = troll;
    }

    @Override
    public String getRacerName() {
        return name;
    }


    @Override
    public int getCartNumber() {
        return kartNumber;
    }


    @Override
    public double getRaceTime() {
        return time;
    }


    @Override
    public int getLap() {
        return currentLap;
    }

    @Override
    public void run() {
       System.out.println(name + "(" + kartNumber + ") is ready to race!");
       synchronized(this) {
           try {
               Thread.sleep(1000);
               troll.addRacer(this);
            } catch (InterruptedException e1) {
                System.err.println("Error");
            }
        }
    }
}
