package ru.spbstu.appmath.trenzenok;

import java.util.ArrayList;
import java.util.List;

public class ExpressionUtilities {

    public static List<Expression.Lexeme> simplifyExpression(final List<Expression.Lexeme> inputExpression) {
        if (inputExpression.size() == 1)
            return inputExpression;

        List<Expression.Lexeme> exp = new ArrayList<>(inputExpression.subList(0, inputExpression.size()));

        for (int i = 0; i < exp.size(); i++) {
            int last = exp.size() - 1;
            if (exp.get(i).isLeftBracket()) {
                int balance = 0;

                for (int j = i + 1; j < exp.size(); j++) {
                    balance += exp.get(j).handleIfBracket();
                    if (balance == -1) {
                        if (((i == 0 || exp.get(i - 1).isLeftBracket() || exp.get(i - 1).getValue().equals("+")) &&
                                (j == last || exp.get(j + 1).isRightBracket() || exp.get(j + 1).getPriorityIfOperand() == 2)) ||
                                (j - i == 2)) {
                            exp.remove(j);
                            exp.remove(i);
                            i--;
                        }
                        break;
                    }
                }
            }
        }

        return exp;
    }

    public static int findFracture(final List<Expression.Lexeme> exp) {
        int brackets = 0;
        int fracture = -1;

        for (int i = 0; i < exp.size(); i++) {
            brackets += exp.get(i).handleIfBracket();
            if (brackets == 0) {
                if (exp.get(i).isOperand()) {
                    if (exp.get(i).getPriorityIfOperand() == 1) {
                        fracture = i;
                    }
                    if (exp.get(i).getPriorityIfOperand() == 2) {
                        fracture = i;
                        break;
                    }
                }
            }
        }
        return fracture;
    }
}
