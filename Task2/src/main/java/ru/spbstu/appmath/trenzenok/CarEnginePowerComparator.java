package ru.spbstu.appmath.trenzenok;

import java.util.Comparator;

public class CarEnginePowerComparator implements Comparator<Car>{
    public int compare(Car car1, Car car2) {
        return Double.compare(car1.getEnginePower(),car2.getEnginePower());
    }
}
