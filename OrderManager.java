package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OrderManager {

    HashMap<String, Order> map;

    public OrderManager() {
        map = new HashMap<>();
    }

    public  void add(Order order, int tableNumber) throws IllegalTableNumber {
        if (map.containsKey(new Integer(tableNumber).toString())) {
            throw new IllegalTableNumber("Table is exists");
        }
        map.put(new Integer(tableNumber).toString(), order);
    }

    public  void add(Order order, String address) throws OrderAlreadyAddedException {
        if (map.containsKey(address)) {
            throw new OrderAlreadyAddedException("Adress is exists");
        }
        map.put(address, order);
    }

    public  void addPosition(Item item, String address) {
        map.get(address).add(item);
    }

    public double totalCost() {
        Iterator it = map.entrySet().iterator();
        double result = 0;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            result += ((Order)pair.getValue()).costTotal();
        }
        return result;
    }

    public void remove(int tableNumber) {
        remove(new Integer(tableNumber).toString());
    }

    public void remove(String address) {
        map.remove(address);
    }

    Order[] getInternetOrders() {
        Order[] orders = new Order[map.size()];
        Iterator it = map.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if (pair.getValue().equals("Internet")) {
                orders[i++] = (Order) pair.getValue();
            }
        }
        return orders;
    }

    int getItemStats(String name) {
        Order[] orders = new Order[map.size()];
        Iterator it = map.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            for (Item tmp : ((Order)pair.getValue()).getDishes()) {
                if (tmp.equals(name)) {
                    i++;
                }
            }
        }
        return i;
    }

}
