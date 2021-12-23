package Lesson_1.Example_1;

public class Human implements Comanda{

    private final String name;
    private int height;
    private int distance;

    public Human(String name, int height, int distance) {
        this.name = name;
        this.height = height;
        this.distance = distance;
    }
    @Override
    public int jump() {
        System.out.println(this.name +" can to jump: " + this.height);
        return this.height;
    }

    @Override
    public int run() {
        System.out.println(this.name + " can to run: " + this.distance);
        return this.distance;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", distance=" + distance +
                '}';
    }
}
