package com.learning.java.lesson2;

public class Oxygen {

    private int volume;

    public Oxygen(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void spend(int value) {
        volume -= value;
    }

    @Override
    public String toString() {
        return volume + "";
    }
}
