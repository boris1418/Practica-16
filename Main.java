package com.company;

public class Main {

    public static void main(String[] args) {
	    OrderManager m = new OrderManager();
	    Order or = new InternetOrder();
        Order or2 = new InternetOrder();
        or2.add(new Dish("Meat","Top", 100));
	    or.add(new Drink("Milk","Top", 100));
	    try {
            m.add(or, "Arbat");
            m.add(or2, 5);
        } catch (Exception e) {
	        e.printStackTrace();
        }

    }
}
