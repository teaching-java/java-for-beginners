package com.developer.java.objects;

import com.developer.java.Alive;
import com.developer.java.PhysicalObject;

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
