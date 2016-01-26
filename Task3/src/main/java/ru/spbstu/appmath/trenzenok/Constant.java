package ru.spbstu.appmath.trenzenok;

public class Constant implements Expression {
    private final double value;

    public Constant(double value) {
        this.value = value;
    }

    public double calculate(double x) {
        return this.value;
    }
}
