package Lesson_1.Example_3;

import Lesson_1.Example_1.Cat;
import Lesson_1.Example_1.Comanda;
import Lesson_1.Example_1.Human;
import Lesson_1.Example_1.Robot;
import Lesson_1.Example_2.Obstacle;
import Lesson_1.Example_2.Track;
import Lesson_1.Example_2.Wall;

import java.util.List;
import java.util.Random;

public class HomeWork1 {
    public static void main(String[] args) {
        System.out.println("Preparatory stages:");
        Event event = createAndPrepareEvent();

        System.out.println("Start championship");
        event.startEvent();

        List<Comanda> lastWinners = event.getLastWinners();
        if (!lastWinners.isEmpty()) {
            System.out.println("Winners: ");
            for (Comanda win : lastWinners) {
                System.out.println(win);
            }
        } else {
            System.out.println("no one has overcome");
        }
    }


    private static Event createAndPrepareEvent() {
        Comanda person = new Human("Egor", 3, 200);
        Comanda cat = new Cat("Tima", 5, 100);
        Comanda robot = new Robot("Bender", 6, 500);

        Random random = new Random();

        Obstacle wall = new Wall(random.nextInt(5));
        Obstacle track = new Track(random.nextInt(500));

        Event event = new Event("Championship");
        event.setObstacles(wall, track);
        event.setPlayers(person, cat, robot);
        return event;

    }
}

