package chezwoolie;

import java.util.LinkedList;
import java.util.Random;

public class ChezWoolie {

    int count;
    LinkedList<FoodItems> conveyor;

    public ChezWoolie (int count, LinkedList<FoodItems> conveyor) {
        this.count = count;
        this.conveyor = conveyor;
    }   

    public int getCount() {
        return count;
    }

    public void enterRestaurant () {
        count++;
    }

    public void leaveRestaurant () {
        count--;
    }

    public FoodItems retrieveFoodItem () {
    if (conveyor.size() == 0) {
        System.out.println("Waiting for item");
    }
    Random random = new Random();
    FoodItems food = conveyor.get(random.nextInt(0, conveyor.size() - 1));
    return food;
    }

    public void serverFood (FoodItems food) {
        conveyor.add(food);
        notifyAll();
    }
}
