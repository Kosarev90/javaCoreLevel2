package Lesson_2;

public class HomeWork2 {

    private static final int REQUIRED_ARRAY_SIZE = 4; // размер массива

    public static final String[][] CORRECT_DATA = new String[][]{ // массив с корректныи данными
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
    };

    public static final String[][] INCORRECT_SIZE_DATA = new String[][]{ //массив с не корректными данными
            {"1", "2", "3", "4"},
            {"5", "6", "7"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
    };

    public static final String[][] INCORRECT_VALUE_DATA = new String[][]{ // Массив с не корректными значениями
            {"1", "2", "3", "4"},
            {"5", "6", "7", "I8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
    };

    private static void checkValue(String[][] data) { // проверка исключений
        if (data.length != REQUIRED_ARRAY_SIZE) { // проверка длинны строк
            throw new MyArraySizeException();
        }
        for (String[] row : data) { // проверка элементов с строке
            if (row.length != REQUIRED_ARRAY_SIZE) {
                throw new MyArraySizeException();
            }
        }
    }

    private static int sumArrayValues(String[][] data) { // суммирование значений в массиве
        checkValue(data);

        int sumResult = 0; //аккумулирующая переменная

        for (int rowIndex = 0; rowIndex < data.length; rowIndex++) {
            String[] row = data[rowIndex];
            for (int colIndex = 0; colIndex < row.length; colIndex++) {
                String stringValue = row[colIndex];
                try {
                    int intValue = Integer.parseInt(stringValue);
                    sumResult += Integer.parseInt(stringValue);
                } catch (NumberFormatException e) {
                    throw new MyArrayDateException(stringValue, rowIndex, colIndex);
                }
            }
        }
        return sumResult;
    }

    public static void main(String[] args) {
        try {
           int sum = sumArrayValues(CORRECT_DATA);
            System.out.println("summa = " + sum);
        } catch (MyArraySizeException | MyArrayDateException e) {
            System.out.println(e.getMessage());
        }
    }
}


