package Lesson_1.Example_3;

import Lesson_1.Example_1.Comanda;
import Lesson_1.Example_2.Obstacle;

import java.util.ArrayList;
import java.util.List;

public class Event {

    private Obstacle [] obstacles;
    private  Comanda [] players;
    private final String eventTitle;

    private final List<Comanda> lastWinners = new ArrayList<>();

    public Event(String eventTitle) {
        this.eventTitle = eventTitle;
    }


    public void setObstacles(Obstacle ... obstacles) {
        this.obstacles = obstacles;
    }

    public void setPlayers(Comanda ... players) {
        this.players = players;
    }
    public List <Comanda> getLastWinners(){
        return lastWinners;
    }
    public void startEvent(){
        System.out.printf("Start event %s", this.eventTitle );

        for (Comanda player : this.players) {
            boolean succes = this.passAllObstacle(player);
            if (! succes) {
                System.out.printf("The participant %s left the event %n", player);
            }else {
                this.lastWinners.add(player);
            }
        }
    }
    private boolean passAllObstacle (Comanda player){
        for (Obstacle obstacle : this.obstacles) {
            if(!obstacle.passObstacleBy(player)){
                return false;
            }
        }
        return true;
    }


}
