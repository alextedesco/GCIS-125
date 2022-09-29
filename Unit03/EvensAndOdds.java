public class EvensAndOdds extends Thread {
    private final int num;

    public EvensAndOdds (int num) {
    this.num = num;
    }
    
    @Override
    public void run () {
        if (num % 2 == 0) {
            for (int i = num; i <= 100; i++) {
                if (i % 2 == 0) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        System.err.println("Interrupted!");
                    }
                    System.out.println(i);
                } else {}
            }
        } else {
            for (int i = num; i <= 100; i++) {
                if (i % 2 == 0) {} else {
                    try {
                        Thread.sleep(49);
                    } catch (InterruptedException e) {
                        System.err.println("Interrupted!");
                    }
                    System.out.println(i);
                }
            }
        }
    }

    public static void main (String[] args) throws InterruptedException {
        Thread odds = new EvensAndOdds (1);
        Thread evens = new EvensAndOdds (2);
        odds.start();
        evens.start();
    }
}