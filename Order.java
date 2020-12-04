package com.company;

public abstract class Order {

    public ArrayQueue<Item> orderList;

    public Order() {
        orderList = new ArrayQueue<>();
    }
    boolean add(Item item) {
        orderList.enqueue(item);
        return true;
    }

    boolean remove(String dishName) {
        boolean res = false;
        Item[] arr = getDishes();
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i].getName().compareTo(dishName) != 0) {
                orderList.enqueue(arr[i]);
            } else {
                res = true;
                for (int j = i + 1; j < arr.length; ++j) {
                    orderList.enqueue(arr[j]);
                }
                break;
            }
        }
        return res;
    }

    int removeAll(String dishName) {
        int removed = 0;
        Item[] arr = getDishes();
        orderList.clear();
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i].getName().compareTo(dishName) != 0) {
                orderList.enqueue(arr[i]);
            } else {
                removed++;
            }
        }
        return removed;
    }

    int dishQuantity() {
        return amount;
    }

    int dishQuantity(String dishName) {
        Item[] arr = getDishes();
        int count = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i].getName().compareTo(dishName) == 0) {
                count++;
            }
        }
        return count;
    }

    Item[] getDishes() {
        Item[] arr = new Item[amount];
        for (int i = 0; i < amount; ++i) {
            arr[i] = orderList.dequeue();
        }
        for (int i = 0; i < amount; ++i) {
            orderList.enqueue(arr[i]);
        }
        Sorter.quickSort(arr);
        return arr;
    }

    double costTotal() {
        Item[] arr = getDishes();
        double cost = 0;
        for (int i = 0; i < arr.length; ++i) {
            cost += arr[i].getCost();
        }
        return cost;
    }

    Item[] sortedDishesByCostDesc() {
        Item[] arr = getDishes();
        Sorter.quickSort(arr);
        return arr;
    }

    public abstract String getType();
    private int amount;

}
