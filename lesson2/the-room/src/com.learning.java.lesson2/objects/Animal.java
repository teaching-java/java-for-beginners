package com.learning.java.lesson2.objects;

import com.learning.java.lesson2.Alive;
import com.learning.java.lesson2.PhysicalObject;

public abstract class Animal implements Alive, PhysicalObject {

    private int size;

    public Animal() {
        this.size = 0;
    }

    @Override
    public void growUp() {
        size = size + 1;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
