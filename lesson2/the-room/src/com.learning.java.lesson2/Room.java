package com.learning.java.lesson2;

public class Room {

    private final int space;
    private final Oxygen oxygen;

    public Room(int requiredSpace) {
        this(requiredSpace, 0);
    }

    public Room(int requiredSpace, int oxygenVolume) {
        this.space = requiredSpace;
        this.oxygen = new Oxygen(oxygenVolume);
    }

    public int getSpace() {
        return space;
    }

    public Oxygen getOxygen() {
        return oxygen;
    }
}
