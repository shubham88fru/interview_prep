package com.learning.lld.coffeevendingmachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeMachine {
    private Map<String, Ingredient> ingredients;
    private List<Coffee> menu;

    public CoffeeMachine() {
        ingredients = new HashMap<>();
        menu = new ArrayList<>();
        initializeIngredients();
        initializeMenu();
    }

    public synchronized Coffee chooseCoffee(CoffeeType coffeeType) {
        for (Coffee coffee : menu) {
            if (coffee.getCoffeeType() == coffeeType) {
                return coffee;
            }
        }

        return null;
    }

    private synchronized void dispenseCoffee(Coffee coffee, Payment payment) {
        if (payment.getAmount() >= coffee.getPrice()) {
            if (enoughIngredient(coffee)) {
                updateIngredients(coffee);
                System.out.println("Dispensing: " + coffee.getCoffeeType().toString());
                double change = payment.getAmount() - coffee.getPrice();
                if (change > 0) {
                    System.out.println("Please collect your change = " + change);
                }
            } else {
                System.out.println("Insufficient ingredients in coffee machine to make " + coffee.getCoffeeType().toString());
            }
        } else {
            System.out.println("Insufficient fund.");
        }
    }

    private boolean enoughIngredient(Coffee coffee) {
        for (Map.Entry<Ingredient, Integer> entry : coffee.getRecipe().entrySet()) {
            Ingredient ingredient = entry.getKey();
            int requiredQty = entry.getValue();

            if (ingredient.getQuantity() < requiredQty) {
                return false;
            }
        }

        return true;
    }

    private void updateIngredients(Coffee coffee) {
        for (Map.Entry<Ingredient, Integer> entry : coffee.getRecipe().entrySet()) {
            Ingredient ingredient = entry.getKey();
            int requiredQty = entry.getValue();
            ingredient.updateQuantity(-requiredQty);

            if (ingredient.getQuantity() < 3) {
                System.out.println("Low on " + ingredient.getName());
            }
        }
    }

    private void initializeMenu() {
        Map<Ingredient, Integer> espressoRecipe = new HashMap<>();
        espressoRecipe.put(ingredients.get("MILK"), 1);
        espressoRecipe.put(ingredients.get("COFFEE"), 2);
        espressoRecipe.put(ingredients.get("WATER"), 1);
        menu.add(new Coffee(CoffeeType.ESPRESSO, 3.0, espressoRecipe));


        Map<Ingredient, Integer> cappucino = new HashMap<>();
        cappucino.put(ingredients.get("MILK"), 1);
        cappucino.put(ingredients.get("COFFEE"), 2);
        cappucino.put(ingredients.get("WATER"), 1);
        menu.add(new Coffee(CoffeeType.CAPPUCCINO, 5.0, cappucino));


        Map<Ingredient, Integer> latte = new HashMap<>();
        latte.put(ingredients.get("MILK"), 1);
        latte.put(ingredients.get("COFFEE"), 2);
        latte.put(ingredients.get("WATER"), 1);

        menu.add(new Coffee(CoffeeType.LATTE, 6.0, latte));
    }

    private void initializeIngredients() {
        ingredients.put("COFFEE_BEANS", new Ingredient("COFFEE_BEANS", 10));
        ingredients.put("MILK", new Ingredient("MILK", 10));
        ingredients.put("WATER", new Ingredient("WATER", 10));
    }

    private void displayMenu() {
        System.out.println("MENU: ");
        for (Coffee coffee : menu) {
            System.out.println(coffee);
        }
    }
}
