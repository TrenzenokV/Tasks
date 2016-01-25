package ru.spbstu.appmath.trenzenok.exceptions;

public class BracketsBalanceException extends WrongSyntaxException {
    public BracketsBalanceException() {
        super();
    }

    public BracketsBalanceException(String message) {
        super(message);
    }
}