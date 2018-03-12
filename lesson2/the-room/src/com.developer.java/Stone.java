package com.developer.java;

public class Stone implements PhysicalObject {

    private int size;

    public Stone(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Stone{" +
                "size=" + size +
                '}';
    }
}
