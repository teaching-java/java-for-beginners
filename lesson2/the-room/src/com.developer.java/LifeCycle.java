package com.developer.java;

import java.util.ArrayList;
import java.util.List;

public class LifeCycle {

    Room room = new Room(100);

    List list = new ArrayList();

    public LifeCycle() {
        Stone stone1 = new Stone(10);
        Stone stone2 = new Stone(12);
        Cow cow = new Cow();
        list.add(stone1);
        list.add(stone2);
        list.add(cow);
    }

    public void start() {
        int cycle = 1;
        while (true) {
            int space = room.getSpace();
            int occupiedSpace = 0;
            for (int i = 0; i < list.size(); i++) {
                Object object = list.get(i);
                if (object instanceof PhysicalObject) {
                    PhysicalObject physicalObject = (PhysicalObject) object;
                    int objectSize = physicalObject.getSize();
                    occupiedSpace += objectSize;
                }
                if (object instanceof Alive) {
                    Alive aliveObject = (Alive) object;
                    aliveObject.growUp();
                }
            }
            if (occupiedSpace > space) {
                System.out.println(cycle);
                list.forEach(System.out::println);
                return;
            }
            cycle++;
            System.out.println(cycle);
            System.out.println(occupiedSpace);
        }
    }
}
