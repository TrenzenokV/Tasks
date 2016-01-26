package ru.spbstu.appmath.trenzenok;

public class ExpressionTree implements Expression {
    private final Expression right;
    private final Expression left;
    private final char operation;

    public ExpressionTree(Expression left, Expression right, char operation) {
        this.right = right;
        this.left = left;
        this.operation = operation;
    }

    public double calculate(double x) throws Exception {
        double resultLeft = left.calculate(x);
        double resultRight = right.calculate(x);
        switch (operation) {
            case '+':
                return (resultLeft + resultRight);
            case '-':
                return (resultLeft - resultRight);
            case '*':
                return (resultLeft * resultRight);
            case '/':
                if (resultRight != 0)
                    return (resultLeft / resultRight);
                else
                    throw new Exception("Division by zero.");
            default:
                return 0;
        }
    }
}