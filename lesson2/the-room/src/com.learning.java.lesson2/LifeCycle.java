package com.learning.java.lesson2;

import java.util.ArrayList;
import java.util.List;

public class LifeCycle {

    private final Room room = new Room(100, 500);

    private final List items = new ArrayList();

    public LifeCycle() {
        Stone stone1 = new Stone(10);
        Stone stone2 = new Stone(12);
        Cow cow1 = new Cow();
        Cow cow2 = new Cow();
        Oxygen o = room.getOxygen();
        items.add(o);
        items.add(stone1);
        items.add(stone2);
        items.add(cow1);
        items.add(cow2);
    }

    public void start() {
        int cycle = 1;
        while (true) {
            int space = room.getSpace();
            int occupiedSpace = 0;
            for (Object object : items) {
                if (object instanceof PhysicalObject) {
                    PhysicalObject physicalObject = (PhysicalObject) object;
                    int objectSize = physicalObject.getSize();
                    occupiedSpace += objectSize;
                }
                if (object instanceof Alive) {
                    Alive aliveObject = (Alive) object;
                    aliveObject.growUp();
                    aliveObject.breathe(room.getOxygen());
                }
            }
            if (occupiedSpace > space) {
                System.out.printf("Not enough space on %d%s cycle\n", cycle, getSuffix(cycle));
                System.out.printf("%d oxygen is available\n", room.getOxygen().getVolume());
                return;
            }
            if (room.getOxygen().getVolume() <= 0) {
                System.out.printf("Not enough oxygen on %d%s cycle\n", cycle, getSuffix(cycle));
                System.out.printf("%d space is available\n", space - occupiedSpace);
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
