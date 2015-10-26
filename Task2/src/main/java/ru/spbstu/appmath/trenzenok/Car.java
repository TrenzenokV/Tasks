package ru.spbstu.appmath.trenzenok;

public class Car {

    public String model;
    public int birthYear;
    public double enginePower;

    public Car(String model, int birthYear, double enginePower) {
        this.model = model;
        this.birthYear = birthYear;
        this.enginePower = enginePower;
    }

    public String getModel() {
        return model;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public double getEnginePower() {
        return enginePower;
    }

}
