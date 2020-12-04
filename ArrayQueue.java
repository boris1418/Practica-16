package com.company;

public class ArrayQueue<T> implements QueueADT<T> {

    public ArrayQueue() {
        this.capacity = 32;
        this.array = new Object[this.capacity];
        this.size = 0;
        this.start = 0;
    }

    @Override
    public void enqueue(T x) {
        if (size >= capacity) {
            Object[] newArray = new Object[capacity * 2];
            int newSize = 0;
            for (int i = start; i < size; ++i) {
                newArray[newSize++] = array[(start + i) % capacity];
            }
            array = newArray;
            this.capacity *= 2;
            this.start = 0;
        }
        array[(start + size) % capacity] = x;
        ++size;
    }

    @Override
    public T element() {
        return (T)array[start];
    }

    @Override
    public T dequeue() {
        if (size != 0) {
            T element = (T)array[start];
            start = (start + 1) % capacity;
            --size;
            return element;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
        start = 0;
    }

    private int capacity;
    private int start;
    private int size;
    private Object[] array;

}
