package Lesson_3.HomeWork_3;

import java.util.*;

public class Car {
    public static void main(String[] args) {

        MyCollectionCar();
    }

    private static void MyCollectionCar() {

        String[] cars = {"lada", "bmw", "mercedes", "toyota", "lada", "mazda", "lexus", "fiat", "alfa-romeo",
                "toyota", "bmw", "lada", "bmw", "bugatti", "rolls-rois", "ferrari", "lexus",};

        Map<String, Integer> map = new TreeMap<>();

        for (String car : cars) {
            map.put(car, map.getOrDefault(car, 0) + 1);
        }
        System.out.println(map);
        System.out.println("------------------------------");

        Set<String> quantity = new TreeSet<>(Arrays.asList(cars));
        System.out.println(quantity);
    }

}