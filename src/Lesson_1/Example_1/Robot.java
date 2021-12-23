package Lesson_1.Example_1;

public class Robot implements Comanda {

    private final String name;
    private int height;
    private int distance;

    public Robot(String name, int height, int distance) {
        this.name = name;
        this.height = height;
        this.distance = distance;
    }
    @Override
    public int jump() {
        System.out.println(this.name + " can to jump: " + this.height);
        return this.height;
    }

    @Override
    public int run() {
        System.out.println(name +" can to run: " + distance);
        return this.distance;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", distance=" + distance +
                '}';
    }
}
