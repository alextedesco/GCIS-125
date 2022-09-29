package part2;

public class Bridge {

    Woolie woolie;

    public Bridge (Woolie woolie) {
        this.woolie = woolie;
    }

    public void setWoolie(Woolie woolie) {
        this.woolie = woolie;
    }

    public void enterBridge () {
        if (woolie.cross == true) {
            Thread thread = new Thread(woolie);
            thread.start();

            while (thread.isAlive() == true) {
            }
            
            leaveBridge();   
        }   
    }

    public void leaveBridge () {
        woolie.setCross(false);
    }
    
}
