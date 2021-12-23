package Lesson_1.Example_2;

import Lesson_1.Example_1.Comanda;

public class Wall implements Obstacle {

    private final int barrier;

    public Wall(int barrier) {
        this.barrier = barrier;
    }

    @Override
    public boolean passObstacleBy(Comanda comanda) {
        if (comanda.jump() >= this.barrier) {
            System.out.println("Practipaint " + comanda + " jumped over the wall height " + this.barrier);
            return true;
        } else System.out.println("Practipaint " + " no jumped over the wall height" + this.barrier);
        return false;
    }
}


