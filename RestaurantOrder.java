package com.company;

public class RestaurantOrder extends Order {
    @Override
    public String getType() {
        return "Restaurant";
    }
}
