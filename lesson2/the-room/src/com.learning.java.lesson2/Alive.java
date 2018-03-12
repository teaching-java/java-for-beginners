package com.learning.java.lesson2;

public interface Alive {

    void growUp();

    default void breathe(Oxygen oxygen) {
        //do nothing
    }

}
