package ru.spbstu.appmath.trenzenok;

import java.util.Comparator;

public class CarModelComparator implements Comparator<Car> {
    public int compare(Car car1, Car car2) {
        return (car1.getModel().compareTo(car2.getModel()));
    }
}

