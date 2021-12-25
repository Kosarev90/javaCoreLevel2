package Lesson_2;

public class MyArrayDateException extends RuntimeException{

    public MyArrayDateException(String cellValue, int rowIndex, int colIndex) {
        super(String.format("Неверное значение '%s' в ячейке [%d][%d]", cellValue, rowIndex, colIndex));
    }
}
