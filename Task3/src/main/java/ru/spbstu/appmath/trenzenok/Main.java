package ru.spbstu.appmath.trenzenok;

public class Main {

    public static void main(String[] args) {
        double x = 0;
        final ExpressionParser calculator = new ExpressionParser();
        Expression result = null;
       // if (args.length == 2) {
            try {
         //       x = Double.valueOf(args[1]);
                result = calculator.calculateExpression("x + (x + 10)");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                System.out.println(result.calculate(x));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        //} else {
          //  System.out.print("Wrong arguments.");
        //}
    }
}
