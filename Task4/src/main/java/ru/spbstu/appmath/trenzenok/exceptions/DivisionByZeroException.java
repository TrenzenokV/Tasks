package ru.spbstu.appmath.trenzenok.exceptions;

public class DivisionByZeroException extends ArithmeticException {
    public DivisionByZeroException() {
        super();
    }

    public DivisionByZeroException(String s) {
        super(s);
    }
}
