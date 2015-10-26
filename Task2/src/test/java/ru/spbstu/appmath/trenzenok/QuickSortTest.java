package ru.spbstu.appmath.trenzenok;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Random;

@RunWith(Parameterized.class)

public class QuickSortTest<T> {

    private static  final Comparator<Car> CAR_ENGINEPOWER_COMPARATOR = new CarEnginePowerComparator();
    private static  final Comparator<Car> CAR_MODEL_COMPARATOR = new CarModelComparator();
    private static  final Comparator<Car> CAR_BIRTHYEAR_COMPARATOR = new CarBirthYearComparator();

    private static final Comparator<Double> DOUBLE_COMPARATOR = new Comparator<Double>() {
        public int compare(final Double o1, final Double o2) {
            return o1.compareTo(o2);
        }
    };
    private static final QuickSort QUICK_SORT = new QuickSort();

    private static Object[][] TEST_DATA_DOUBLE = doubleDataInit();
    private static Object[][] TEST_DATA_CARS = {
            {QUICK_SORT, CAR_ENGINEPOWER_COMPARATOR, new Car[]{}},
            {QUICK_SORT, CAR_MODEL_COMPARATOR, new Car[]{new Car("mercedes", 2010, 220.8), new Car("audi", 2009, 450.5), new Car("bmw", 2011, 245)}},
            {QUICK_SORT, CAR_BIRTHYEAR_COMPARATOR, new Car[]{new Car("toyota", 2015, 150.7), new Car("nissan", 2014, 300)}},
            {QUICK_SORT, CAR_ENGINEPOWER_COMPARATOR, new Car[]{new Car("honda", 2003, 100), new Car("mazda", 2007, 98.7), new Car("ferrari", 2003, 480)}}
    };

    private static Object[][] doubleDataInit() {
        int size = 4;
        Object[][] data = new Object[size][3];
        Random random = new Random();
        int numOfElem;
        Double[] array;
        for (int i = 0; i < size; i++) {
            numOfElem = random.nextInt(50);
            array = new Double[numOfElem];
            for (int j = 0; j < array.length; j++) {
                array[j] = Math.floor(random.nextDouble() * 200.0) / 30.0 - 5.0;
            }
            data[i][0] = QUICK_SORT;
            data[i][1] = DOUBLE_COMPARATOR;
            data[i][2] = array;
        }

        return data;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
          return Arrays.asList(TEST_DATA_CARS);
        //return  Arrays.asList(TEST_DATA_DOUBLE);
    }

    private Sort<T> sort;
    private T[] input;
    private Comparator<T> comparator;

    public QuickSortTest(Sort<T> sort, Comparator<T> comparator, T[] input) {
        this.sort = sort;
        this.comparator = comparator;
        this.input = input;
    }

    @Test
    public void test() {

        T[] result = sort.sort(input, comparator);

        Assert.assertTrue("The array isn't sorted", testAscendingOrder(result, comparator));
        Assert.assertEquals("Result array length should be equal to original", input.length, result.length);
        Assert.assertTrue(hasEachElementOf(input, result, comparator));
    }

    private boolean testAscendingOrder(T[] array, Comparator<T> comparator) {
        for (int i = 0; i < array.length - 1; i++) {
            if (comparator.compare(array[i],array[i+1]) > 0)
                return false;
        }
        return true;
    }

    private boolean hasEachElementOf(T[] input, T[] result, Comparator<T> comparator) {
        for (T element : input) {
            for (int j = 0; j < result.length; j++) {
                if (comparator.compare(result[j],element) == 0)
                    break;
                if (j == result.length - 1)
                    return false;
            }
        }
        return true;
    }

}
