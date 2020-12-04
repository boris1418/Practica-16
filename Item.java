package com.company;

public abstract class Item implements Comparable {

    @Override
    public int compareTo(Object o) {
        if (cost == ((Item)o).cost) {
            return 0;
        } else return (int)(cost - ((Item)o).cost);
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    private double cost;
    private String name;
    private String description;

}
