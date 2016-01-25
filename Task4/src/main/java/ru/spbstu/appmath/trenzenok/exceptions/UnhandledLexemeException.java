package ru.spbstu.appmath.trenzenok.exceptions;

public class UnhandledLexemeException extends WrongSyntaxException {
    public UnhandledLexemeException() {
        super();
    }

    public UnhandledLexemeException(String message) {
        super(message);
    }
}
