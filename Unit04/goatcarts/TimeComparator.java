package goatcarts;

import java.util.Comparator;

public class TimeComparator implements Comparator<GoatKart> {

    @Override
    public int compare(GoatKart kart1, GoatKart kart2) {
        return kart1.time - kart2.time;
    }
}
