package com.naripin.borgorkongapp;

public class BurgerItem {

    // Unique identifier of the burger
    private int burgerID;

    // Burger attributes
    private String name;
    private double cost;
    private String description;
    private int imageDrawableId;

    public BurgerItem(int burgerID, String name, double cost, String description, int imageDrawableId) {
        this.burgerID = burgerID;
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.imageDrawableId = imageDrawableId;
    }

    public int getBurgerID() {
        return burgerID;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }


    public String getDescription() {
        return description;
    }


    public int getImageDrawableId() {
        return imageDrawableId;
    }
}

