package Lesson_1.Example_2;

import Lesson_1.Example_1.Comanda;


public class Track implements Obstacle {

    private final int distance;

    public Track(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean passObstacleBy(Comanda comanda) {
        if (comanda.run() >= this.distance) {
            System.out.println("Practipaint " + comanda + " jumped over the wall height " + this.distance);
            return true;
        } else{
            System.out.println("Practipaint " + comanda + " No jumped over the wall height " + this.distance);
            return false;
        }
    }
}

