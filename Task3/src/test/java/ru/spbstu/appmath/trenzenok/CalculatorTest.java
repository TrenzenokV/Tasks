package ru.spbstu.appmath.trenzenok;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class CalculatorTest {
    private Double variable;
    private Double result;
    private String expression;
    private String error;

    public CalculatorTest(String expression, Double variable, Double result, String error) {
        this.variable = variable;
        this.result = result;
        this.expression = expression;
        this.error = error;
    }

    private static final Object[][] TEST_DATA = new Object[][]{
            {"fahsjdfbhjasd", 0.0, 0.0, "Wrong symbol."},
            {"14 + 3/0", 0.0, 0.0, "Division by zero."},
            {"x", 2.0, 2.0, ""},
            {"1 + x", 2.0, 3.0, ""},
            {"((((2 + 6)", 0.0, 0.0, "Wrong number of brackets."}
    };

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(TEST_DATA);
    }

    @Test
    public void test() {
        try {
            Assert.assertTrue("Wrong answer", checkAnswer());
        } catch (Exception e) {
            Assert.assertTrue("Wrong exception", checkException(e.getMessage()));
        }

    }


    private boolean checkException(String exception) {
        System.out.println(exception);
        if (!exception.equals(error))
            return false;
        else
            return true;
    }

    private boolean checkAnswer() throws Exception {
        final Calculator calculator = new Calculator();
        Expression res = calculator.calculateExpression(expression);
        if (res.calculate(variable) != result)
            return false;
        else
            return true;
    }
}
