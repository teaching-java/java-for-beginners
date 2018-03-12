package com.learning.java.lesson2;

public class Oxygen {

    private int volume;

    public Oxygen(int volume) {
        this.volume = volume;
    }

    public boolean isAbsent() {
        return volume <= 0;
    }

    public void spend(int value) {
        volume -= value;
    }

    @Override
    public String toString() {
        return volume + "";
    }
}
