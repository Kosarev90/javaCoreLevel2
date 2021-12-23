package Lesson_1.Example_1;

public class Cat implements Comanda{

    private final String name;
    private final int height;
    private final  int distance;

    public Cat(String name, int height, int distance) {
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
        System.out.println(name + " can to run: " + distance);
        return this.distance;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", distance=" + distance +
                '}';
    }
}
