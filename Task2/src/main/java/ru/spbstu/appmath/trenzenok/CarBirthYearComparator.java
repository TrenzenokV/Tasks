package ru.spbstu.appmath.trenzenok;

import java.util.Comparator;

public class CarBirthYearComparator implements Comparator<Car> {
    public int compare(Car car1, Car car2) {
        return Integer.compare(car1.getBirthYear(), car2.getBirthYear());
    }
}
