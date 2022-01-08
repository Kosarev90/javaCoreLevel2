package Lesson_5.HomeWork;

import java.util.Arrays;

public class HomeWorkThread {

    private static final int SIZE = 1_000_000;
    private static final int HALF_SIZE = SIZE / 2;

    public float[] result(float[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return array;
    }

    public void oneThread() {
        float[] array = new float[SIZE];
        for (int i = 1; i < array.length; i++) {
            array[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        result(array);
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public void twoThreads() {
        float[] array = new float[SIZE];
        float[] array1 = new float[HALF_SIZE];
        float[] array2 = new float[HALF_SIZE];

        Arrays.fill(array, 0.1f);
        Arrays.fill(array1, 0.1f);
        Arrays.fill(array2, 0.1f);

        long startTime = System.currentTimeMillis();
        System.arraycopy(array, 0, array1, 0, HALF_SIZE);
        System.arraycopy(array, HALF_SIZE, array2, 0, HALF_SIZE);

        new Thread() {
            public void run() {
                float[] arr1 = result(array1);
                System.arraycopy(arr1, 0, array1, 0, arr1.length);
            }
        }.start();

        new Thread() {
            public void run() {
                float[] arr2 = result(array2);
                System.arraycopy(arr2, 0, array2, 0, arr2.length);
            }
        }.start();

        System.arraycopy(array1, 0, array, 0 , HALF_SIZE);
        System.arraycopy(array2, 0, array, HALF_SIZE , HALF_SIZE);
        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public static void main(String[] args) {
        HomeWorkThread hm = new HomeWorkThread();
        hm.oneThread();
        hm.twoThreads();
    }
}
