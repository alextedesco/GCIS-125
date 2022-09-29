package goatcarts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Troll implements TrollInterface {


    int readyToRace = 0;
    ArrayList<GoatKart> list = new ArrayList<>();

    public Troll () {}

    public void addRacer (GoatKart kart) {
        list.add(kart);
        readyToRace++;
    }

    @Override
    public boolean getRaceFinished() {
        // for (GoatKart goat : list) {

        // }
        return false;
    }

    @Override
    public GoatCartInterface[] getPositions() {
        GoatCartInterface[] array = {};
        Collections.sort(list, new TimeComparator()); // Sorts by time
        return list.toArray(array);
    }

    @Override
    public int getNumRacers() {
        return readyToRace;
    }

    @Override
    public int getNumLaps() {
        return 3;
    }

    @Override
    public String getDialog() {
        if (list.size() == 8) {
            return "Race starting!";
        }
        return "";
    }

    @Override
    public void runRace() {
    }
}
