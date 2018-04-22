package com.learning.java.lesson2;

public class Cow implements Alive, PhysicalObject {

    private int size;

    public Cow() {
        this.size = 0;
    }

    @Override
    public void growUp() {
        size += 7;
    }

    @Override
    public void breathe(Oxygen oxygen) {
        oxygen.spend(size / 2);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Cow{" +
                "size=" + size +
                '}';
    }
}
