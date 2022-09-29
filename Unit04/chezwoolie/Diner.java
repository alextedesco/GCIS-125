package chezwoolie;

import java.util.Random;

public class Diner extends Thread {

    String name;
    Random random = new Random();
    int hungerRating = random.nextInt(5, 10);
    ChezWoolie restaurant;
    long woolesecond = 1000;

    public Diner (String name, int hungerRating, ChezWoolie restaurant) {
        this.name = name;
        this.hungerRating = hungerRating;
        this.restaurant = restaurant;
    }

    public void enterRestaurant () {
        restaurant.enterRestaurant();
    }

    public void leaveRestaurant () {
        restaurant.leaveRestaurant();
    }

    public void eatFood () throws InterruptedException {
        Thread.sleep(woolesecond);
        FoodItems food = restaurant.retrieveFoodItem();
        int servings = food.servings;
        System.out.println(name + " begins to eat 2 servings of " +  food.name);
        hungerRating = hungerRating - servings;
    }

    @Override
    public synchronized void run() {
        enterRestaurant();
        while (hungerRating > 0) {
            if (restaurant.conveyor.size() == 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    System.err.println("Error!");
                }
            }

            try {
                eatFood();
            } catch (InterruptedException e) {
                System.err.println("Error!");
            }
        }
            if (hungerRating <= 0) {
            leaveRestaurant();
            }
        }
    }

