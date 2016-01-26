package ru.spbstu.appmath.trenzenok;

public class Calculator {
    public Expression calculateExpression(String str) throws Exception {

        if (str.equals(""))
            throw new Exception("Empty input.");
        if (!checkSymbols(str))
            throw new Exception("Wrong symbol.");
        if (!numOfBrackets(str))
            throw new Exception("Wrong number of brackets.");
        int lenStr = str.length();
        int pos;

        if ((pos = findPosition(str, '+')) != -1)
            return new ExpressionTree(calculateExpression(str.substring(0, pos)), calculateExpression(str.substring(pos + 1)), '+');

        if ((pos = findPosition(str, '-')) != -1)
            return new ExpressionTree(calculateExpression(str.substring(0, pos)), calculateExpression(str.substring(pos + 1)), '-');

        if ((pos = findPosition(str, '*')) != -1)
            return new ExpressionTree(calculateExpression(str.substring(0, pos)), calculateExpression(str.substring(pos + 1)), '*');

        if ((pos = findPosition(str, '/')) != -1)
            return new ExpressionTree(calculateExpression(str.substring(0, pos)), calculateExpression(str.substring(pos + 1)), '/');

        if (str.charAt(0) == '(')
            return calculateExpression(str.substring(1, lenStr - 1));

        int count = 0;
        for (int i = 0; i < lenStr; i++) {

            if (str.charAt(i) == '(')
                count++;
            if (str.charAt(i) == ')')
                count--;
            if (Character.isDigit(str.charAt(i)) && count == 0) {
                return new Constant(Double.valueOf(str));
            }
        }
        if (findPosition(str, 'x') != -1)
            return new Variable();
        throw new Exception("Syntax error.");
    }

    private int findPosition(String str, char symbol) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                count++;
            if (str.charAt(i) == ')')
                count--;
            if (str.charAt(i) == symbol && count == 0) {
                return i;
            }
        }
        return -1;
    }

    private boolean numOfBrackets(String str) {
        int countLeft = 0;
        int countRight = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                countLeft++;
            if (str.charAt(i) == ')')
                countRight++;
        }
        if (countLeft != countRight)
            return false;
        return true;
    }
    
    private boolean checkSymbols(String str) {
        char correctSymbol[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' ', '+', '-', '*', '/', '(', ')', 'x', '.'};
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < correctSymbol.length; j++) {
                if (str.charAt(i) != correctSymbol[j]) {
                    counter++;
                }
            }
            if (counter == correctSymbol.length)
                return false;
            counter = 0;
        }
        return true;
    }

}