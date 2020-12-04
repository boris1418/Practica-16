package com.company;

public class OrderAlreadyAddedException extends Exception {
    public OrderAlreadyAddedException(String text) {
        super(text);
    }
}
