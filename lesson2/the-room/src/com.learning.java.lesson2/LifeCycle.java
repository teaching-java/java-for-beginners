package com.learning.java.lesson2;

import java.util.ArrayList;
import java.util.List;

public class LifeCycle {

    private final Room room = new Room(100);

    private final List items = new ArrayList();

    public LifeCycle() {
        Stone stone1 = new Stone(10);
        Stone stone2 = new Stone(12);
        Cow cow = new Cow();
        items.add(stone1);
        items.add(stone2);
        items.add(cow);
    }

    public void start() {
        int cycle = 1;
        while (true) {
            int space = room.getSpace();
            int occupiedSpace = 0;
            for (int i = 0; i < items.size(); i++) {
                Object object = items.get(i);
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
                System.out.printf("The room is overcrowded on %d%s cycle\n", cycle, getSuffix(cycle));
                return;
            }
            cycle++;
        }
    }

    private String getSuffix(int cycle) {
        if (cycle % 100 / 10 == 1) { // 11, 12, 13, etc
            return "th";
        }
        if (cycle % 10 == 1) { // first
            return "st";
        }
        if (cycle % 10 == 2) { // second
            return "nd";
        }
        if (cycle % 10 == 3) { // third
            return "rd";
        }
        return "th";
    }
}
