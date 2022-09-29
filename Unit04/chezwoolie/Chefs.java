package chezwoolie;

import java.util.LinkedList;

public class Chefs extends Thread {

    String name;
    ChezWoolie restaurant;
    Long wooleconds = (long) 1000;

    LinkedList<FoodItems> foodItems = new LinkedList<>();

    public Chefs (String name, ChezWoolie restaurant, LinkedList<FoodItems> foodItems ) {
        this.restaurant = restaurant;
        this.foodItems = foodItems;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (this) {
            while (restaurant.count == 0) {
                try {
                    this.wait();
                    System.out.println(name + " is early! Waiting for customers");
                } catch (InterruptedException e) {
                    System.err.println("Error!");
                }
            }
        }
        while (restaurant.count > 0) {
            restaurant.retrieveFoodItem();
            try {
                Thread.sleep(wooleconds);
            } catch (InterruptedException e) {
                System.err.println("Error!");
            }
        }
        System.out.println(name + " has left the restaurant");
    }
}
