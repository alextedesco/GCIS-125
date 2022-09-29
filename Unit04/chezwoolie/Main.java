package chezwoolie;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        LinkedList<FoodItems> conveyor = new LinkedList<>();
        FoodItems pizza = new FoodItems("Pepperoni Pizza", 2);
        conveyor.add(pizza);
        FoodItems fries = new FoodItems("French Fries", 2);
        conveyor.add(fries);
        FoodItems turkeyLeg = new FoodItems("Turkey Leg", 3);
        conveyor.add(turkeyLeg);
        FoodItems strawberryShortcake = new FoodItems("Strawberry Shortcake", 2);
        conveyor.add(strawberryShortcake);
        FoodItems bananaSplit = new FoodItems("Banana Split", 5);
        conveyor.add(bananaSplit);
        ChezWoolie restaurant = new ChezWoolie(0, conveyor);

        System.out.println("Chez Woolie is opening for the day!");

        // Create and start 10 diners, and 2 chefs.
        Chefs chef1 = new Chefs("Chef #1", restaurant, conveyor);
        chef1.start();
        Chefs chef2 = new Chefs("Chef #1", restaurant, conveyor);
        chef2.start();

        for (int i = 1; i <= 10; i++) {
            Diner diner = new Diner("Diner #" + i, 5, restaurant);
            diner.start();
            diner.join();
        }

        // Wait until all of the chefs have left the restaurant, and
        // print a message that the restaurant is closing for the day.
        if (restaurant.count == 0) {
            System.out.println("Chez Woolie is closing for the night!");
        }
    }
}
