package Lesson_2;

public class MyArraySizeException extends IllegalArgumentException{

    public MyArraySizeException() {
        super("Выход за размер массива. Расзмер массива должен 4х4");
    }
}
