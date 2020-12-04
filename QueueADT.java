package com.company;

public interface QueueADT <T> {

    void enqueue(T x);
    T element();
    T dequeue();
    int size();
    boolean isEmpty();
    void clear();

}
